package tool.component.syntactic;

import tool.component.register.Token;

import java.util.ArrayList;

public class Automata {

    private static Automata instance;
    private static TokenContainer tc;
    private static Pushdown pd;

    private Grammar pGrmr;
    private Token pTkn;
    private int pointSwitch;

    private String swapMemory;

    private Automata(){
        swapMemory = "";
    }

    private static void init(){
        if (instance == null){
            instance = new Automata();
            tc = TokenContainer.get();
            pd = Pushdown.get();
        }
    }

    public static Automata get(){
        init();
        return instance;
    }

    public static void end(){
        tc = null;
        pd = null;
        instance = null;
    }

    public void set(ArrayList<Object> tokens){
        tokens.add(pd.getConstraint());
        tc.in(tokens);
    }

    public void parse(){
        while (tc.hasValue()){
            input();
            proceed();
        }
    }

    private void input(){
        Object obj = tc.out();
        if (obj instanceof Token){
            pTkn = (Token) obj;
            pGrmr = null;
            pointSwitch = 0;
        } else {
            pTkn = null;
            pGrmr = (Grammar) obj;
            pointSwitch = 1;
        }
    }

    private void proceed(){
        if (pointSwitch == 1){
            push(pGrmr.getPrecedence());
        } else {
            push(pTkn.getPrecedence());
        }
    }

    private void push(double precedence) {
        if (pd.getPointSwitch() == 1){
            Grammar gmr = (Grammar)pd.peek();
            if (gmr.getPrecedence() > precedence){
                gmr = (Grammar) pd.pop();
                swap(gmr.getValue());
            } else {
                push();
            }
        } else {
            Token tkn = (Token) pd.peek();
            if (tkn.getPrecedence() > precedence){
                tkn = (Token) pd.pop();
                swap(tkn.getValue());
            } else {
                push();
            }
        }
    }

    private void push(){
        Grammar gmr = GrammarTableManager.get().grammar(swapMemory);
        pd.push(gmr);
        swapMemory = "";
    }

    private void swap(double key){
        swapMemory = swapMemory + key;
    }


}
