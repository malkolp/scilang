package tool.component.syntactic;

import tool.component.register.Token;

import java.util.ArrayList;

public class Automata {

    private static Automata instance;
    private static TokenContainer tc;
    private static Pushdown pd;

    private Automata(){}

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

    public void set(ArrayList<Token> tokens){
        tokens.add(pd.getConstraint());
        tc.in(tokens);
    }

    public void parse(){

    }
}
