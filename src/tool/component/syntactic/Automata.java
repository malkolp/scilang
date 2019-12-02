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

    }

    private void swap(double key){
        swapMemory = swapMemory + key;
    }


}
