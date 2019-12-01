package tool.component.api;

import tool.component.register.Token;
import tool.component.syntactic.Grammar;

import java.util.HashMap;


public class GrammarProcessor {

    private static GrammarProcessor instance;
    private HashMap<String,Grammar> grammarTable;

    private GrammarProcessor(){
        grammarTable = new HashMap<>();
    }

    private static void init(){
        if (instance == null)
            instance = new GrammarProcessor();
    }

    public static GrammarProcessor get(){
        init();
        return instance;
    }

    public static void end(){
        instance = null;
    }

    public void add(Token[] tokens,String key,double value, double precedence){

    }

    public void add(Grammar[] grammars,String key,double value, double precedence){

    }

    public void save(String file_url){

    }

    public void load(String file_url){

    }

}
