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

    public void add(Token[] tokens,String key, double precedence){
        String token_key = "";
        for (Token t:tokens) token_key = token_key + t.getValue();
        valPoint = Math.round((valPoint + 0.1) * 100.0) / 100.0;
        Grammar g = new Grammar(key, valPoint, precedence);
        addedGrammar.add(g);
        addedChild.add(token_key);
        GrammarTableManager.get().add(token_key,g);
    }

    public void add(Grammar[] grammars,String key, double precedence){
        String grammar_key = "";
        for (Grammar g:grammars) grammar_key = grammar_key + g.getValue();
        valPoint = Math.round((valPoint + 0.1) * 100.0) / 100.0;
        Grammar g = new Grammar(key, valPoint, precedence);
        addedGrammar.add(g);
        addedChild.add(grammar_key);
        GrammarTableManager.get().add(grammar_key,g);
    }

    public void save(String file_url){
        Thread thread = new Thread(() -> {
            grammarList.addAll(addedGrammar);
            grammarChild.addAll(addedChild);

            File file = new File(file_url);
            FileWriter writer;
            BufferedWriter bwriter;
            try {
                file.createNewFile();
                writer = new FileWriter(file);
                bwriter = new BufferedWriter(writer);

                for (int i = 0; i < grammarList.size(); i++){
                    bwriter.write(write(
                            i+1,
                            grammarChild.get(i),
                            grammarList.get(i).getKey(),
                            grammarList.get(i).getValue(),
                            grammarList.get(i).getPrecedence()
                    ));
                }
                bwriter.close();
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        thread.start();
    }

    public void load(String file_url){
        Pattern loader = Pattern.compile("\\d.\\s+\\|\\s+([\\d.]+)\\s+\\|\\s+([\\w]+)\\s+\\|\\s+([\\d]+.[\\d]+)\\s+\\|\\s+([\\d]+.[\\d]+)");
        Matcher m;
        File file;
        try {
            file = new File(file_url);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tmp        = "";
            String child      = "";
            String key        = "";
            double value      = 0;
            double precedence = 0;
            Grammar grmr;
            while ((tmp = reader.readLine()) != null){
                m = loader.matcher(tmp);
                if (m.find()){
                    child      = m.group(1);
                    key        = m.group(2);
                    value      = Double.parseDouble(m.group(3));
                    precedence = Double.parseDouble(m.group(4));
                    grmr = new Grammar(key,value,precedence);
                    grammarChild.add(child);
                    grammarList.add(grmr);
                    GrammarTableManager.get().add(child,grmr);
                }
            }
            valPoint = value;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private String write(int index, String child, String key,double value, double precedence){
        return index+".\t|\t"+child+"\t|\t"+key+"\t|\t"+value+"\t|\t"+precedence+"\n";
    }

}
