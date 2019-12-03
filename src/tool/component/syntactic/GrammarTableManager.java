package tool.component.syntactic;

import java.util.HashMap;

public class GrammarTableManager {

    private static GrammarTableManager instance;
    private static HashMap<String,Grammar> grammarTable;

    private GrammarTableManager(){
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
        instance = null;
    }

    public void add(String key,Grammar grammar){
        if (!grammarTable.containsKey(key))
            grammarTable.put(key,grammar);
    }

    public Grammar grammar(String key){
        return grammarTable.get(key);
    }
}
