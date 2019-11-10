package tool.component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TokenTableManager {

    private static TokenTableManager instance;
    private static HashMap<String,Double> tokenTable;

    static final String IDENTIFIER = "#$id";
    static final String CONSTANT = "#$const";
    static final String ERROR = "#$err";

    private TokenTableManager(){
        tokenTable = new HashMap<>();
        tokenTable.put(ERROR,0.0);
        tokenTable.put(IDENTIFIER,0.1);
        tokenTable.put(CONSTANT,0.2);
    }

    private static void init(){
        if (instance == null)
            instance = new TokenTableManager();
    }

    static TokenTableManager get(){
        init();
        return instance;
    }

    static void end(){
        tokenTable = null;
        instance = null;
    }

    void add(String key,double token){
        tokenTable.put(key,token);
    }

    void remove(){tokenTable.clear();}

    static double token(String key){
        return tokenTable.get(key);
    }

    static boolean contains(String key){
        return tokenTable.containsKey(key);
    }

}
