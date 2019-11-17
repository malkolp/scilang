package tool.component.syntactic;

import tool.component.register.Token;

import java.util.ArrayList;

class TokenContainer {

    private static TokenContainer instance;
    private ArrayList<Token> tokenList;

    private TokenContainer(){
    }

    private static void init(){
        if (instance == null) instance = new TokenContainer();
    }

    static TokenContainer get(){
        init();
        return instance;
    }

    void in(ArrayList<Token> tokenList){
        this.tokenList = tokenList;
    }

    Token out(){
        Token n = tokenList.get(0);
        tokenList.remove(0);
        return n;
    }

}
