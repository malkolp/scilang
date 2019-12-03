package tool;

import tool.component.ToolManager;
import tool.component.api.GrammarProcessor;
import tool.component.api.TokenProcessor;

public class Sci {

    private static ToolManager instance;

    private Sci(){}

    public static ToolManager getComponent(){
        init();
        return instance;
    }

    public static void end(){
        instance = null;
    }

    private static void init(){
        if (instance == null) instance = new ToolManager();
    }

    public static void load(String grammar,String token){
        TokenProcessor.get().load(token);
        GrammarProcessor.get().load(grammar);
    }
}
