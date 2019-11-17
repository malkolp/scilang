package tool.component.register;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TokenTableManager {

    private static TokenTableManager instance;
    private static HashMap<String,Token> tokenTable;

    static final String IDENTIFIER = "#$id";
    static final String CONSTANT = "#$const";
    static final String ERROR = "#$err";

    private TokenTableManager(){
        tokenTable = new HashMap<>();
        Token ERR = new Token(ERROR,-9.9,0,0,0);
        Token CONST = new Token(CONSTANT,0.1,9,1,0);
        Token ID = new Token(IDENTIFIER,0.2,9,2,0);
        tokenTable.put(ERROR,ERR);
        tokenTable.put(CONSTANT,CONST);
        tokenTable.put(IDENTIFIER,ID);
    }

    private static void init(){
        if (instance == null)
            instance = new TokenTableManager();
    }

    public static TokenTableManager get(){
        init();
        return instance;
    }

    public static void end(){
        tokenTable = null;
        instance = null;
    }

    public void add(String key,Token token){
        tokenTable.put(key,token);
    }

    public void remove(){tokenTable.clear();}

    public static Token token(String key){
        return tokenTable.get(key);
    }

    public static boolean contains(String key){
        return tokenTable.containsKey(key);
    }

}

