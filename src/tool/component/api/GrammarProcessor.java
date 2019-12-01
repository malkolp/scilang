package tool.component.api;

import tool.component.register.Token;
import tool.component.syntactic.Grammar;

import java.util.ArrayList;


public class GrammarProcessor {

    private static GrammarProcessor instance;
    private static ArrayList<Grammar> grammarList;
    private static ArrayList<String> grammarChild;

    private GrammarProcessor(){
        grammarList = new ArrayList<>();
        grammarChild = new ArrayList<>();
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
        String token_key = "";
        for (Token t:tokens) token_key = token_key + t.getValue();
        grammarList.add(new Grammar(key, value, precedence));
        grammarChild.add(token_key);
    }

    public void add(Grammar[] grammars,String key,double value, double precedence){

    }

    public void save(String file_url){

    }

    public void load(String file_url){

    }

}
