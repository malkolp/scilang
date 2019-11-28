package tool.component.register;

import java.util.HashMap;

public class TokenTableManager {

    private static TokenTableManager instance;
    private static HashMap<String,Token> tokenTable;

    static final String IDENTIFIER = "#$id";
    static final String CONSTANT = "#$const";
    static final String ERROR = "#$err";
    private static String USE = "use";
    private static String NAME = "name";

    private TokenTableManager(){
        tokenTable = new HashMap<>();
        Token ERR = new Token(ERROR,-9.9,0,0,0);
        Token CONST = new Token(CONSTANT,0.1,9,1,0);
        Token ID = new Token(IDENTIFIER,0.2,9,2,0);
        Token US = new Token(USE,0.3,9,0,0);
        Token NM = new Token(NAME,0.4,9,0,0);
        tokenTable.put(ERROR,ERR);
        tokenTable.put(CONSTANT,CONST);
        tokenTable.put(IDENTIFIER,ID);
        tokenTable.put(USE,US);
        tokenTable.put(NAME,NM);
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

    public void set_USE(String key){
        tokenTable.remove(USE);
        USE = key;
        tokenTable.put(key,new Token(key,0.3,9,0,0));
    }

    public void set_NAME(String key){
        tokenTable.remove(NAME);
        NAME = key;
        tokenTable.put(key,new Token(key,0.4,9,0,0));
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

    public String get_USE(){
        return USE;
    }

    public String get_NAME(){
        return NAME;
    }
}

