package tool.component.api;

import tool.component.register.Token;
import tool.component.syntactic.Grammar;
import tool.component.syntactic.GrammarTableManager;

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
        grammarChild = null;
        grammarList = null;
        instance = null;
    }

    public void add(Token[] tokens,String key,double value, double precedence){
        String token_key = "";
        for (Token t:tokens) token_key = token_key + t.getValue();
        Grammar g = new Grammar(key, value, precedence);
        grammarList.add(g);
        grammarChild.add(token_key);
        GrammarTableManager.get().add(token_key,g);
    }

    public void add(Grammar[] grammars,String key,double value, double precedence){
        String grammar_key = "";
        for (Grammar g:grammars) grammar_key = grammar_key + g.getValue();
        Grammar g = new Grammar(key, value, precedence);
        grammarList.add(g);
        grammarChild.add(grammar_key);
        GrammarTableManager.get().add(grammar_key,g);
    }

    public void save(String file_url){

    }

    public void load(String file_url){

    }

}
