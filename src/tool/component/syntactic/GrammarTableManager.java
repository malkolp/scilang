package tool.component.syntactic;

import java.util.HashMap;

public class GrammarTableManager {

    private static GrammarTableManager instance;
    private static HashMap<String,Grammar> grammarTable;
    private static HashMap<String,String> grammarChild;

    private GrammarTableManager(){
        grammarChild = new HashMap<>();
        grammarTable = new HashMap<>();
    }

    private static void init(){
        if (instance == null)
            instance = new GrammarTableManager();
    }

    public static GrammarTableManager get(){
        init();
        return instance;
    }

    public static void end(){
        grammarTable = null;
        grammarChild = null;
        instance = null;
    }

    public void add(String key,String key2,Grammar grammar){
        if (!grammarTable.containsKey(key)){
            grammarTable.put(key,grammar);
            if (!grammarChild.containsKey(key2))
                grammarChild.put(key2,key);
        }
    }

    public Grammar grammar(String key){
        return grammarTable.get(key);
    }

    public Grammar grammarChild(String key){
        String keyGrammar = grammarChild.get(key);
        return grammarTable.get(keyGrammar);
    }
}
