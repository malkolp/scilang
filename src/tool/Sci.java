package tool;

import tool.component.ToolManager;

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
}
