package tool.component.syntactic;

import java.util.ArrayList;

class TokenContainer {

    private static TokenContainer instance;
    private ArrayList<Object> tokenList;

    private TokenContainer(){
    }

    private static void init(){
        if (instance == null) instance = new TokenContainer();
    }

    static TokenContainer get(){
        init();
        return instance;
    }

    void in(ArrayList<Object> tokenList){
        this.tokenList = tokenList;
    }

    Object out(){
        Object n = tokenList.get(0);
        tokenList.remove(0);
        return n;
    }

    boolean hasValue(){
        return tokenList.size()>1;
    }

}
