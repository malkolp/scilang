package tool.component.api;

import tool.component.register.Token;
import tool.component.syntactic.Grammar;
import tool.component.syntactic.GrammarTableManager;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GrammarProcessor {

    private static GrammarProcessor instance;
    private static ArrayList<Grammar> grammarList;
    private static ArrayList<String> grammarChild;
    private static ArrayList<Grammar> addedGrammar;
    private static ArrayList<String> addedChild;
    private static double valPoint;

    private GrammarProcessor(){
        grammarList = new ArrayList<>();
        grammarChild = new ArrayList<>();
        addedGrammar = new ArrayList<>();
        addedChild = new ArrayList<>();
        valPoint = 0.0;
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
        addedChild = null;
        addedGrammar = null;
        instance = null;
    }


    public void save(String file_url){
        Thread thread = new Thread(() -> {

        });

        thread.start();
    }

    public void load(String file_url){

    }

    private String write(int index, String child, String key,double value, double precedence){
        return index+".\t|\t"+child+"\t|\t"+key+"\t|\t"+value+"\t|\t"+precedence+"\n";
    }

}
