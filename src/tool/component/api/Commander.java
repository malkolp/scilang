package tool.component.api;


public class Commander {

    private static Commander instance;
    private OSNode os;
    private String compileApp,runApp;
    private String[] command;

    private Commander(){}

    private static void init(){
        if (instance == null) instance = new Commander();
    }

    public static Commander get(){
        init();
        return instance;
    }

    public static void end(){
        instance = null;
    }

    public void setOS(OSNode os){
        this.os = os;
    }

    public void setCompileBash(String bashName){
        this.compileApp = bashName;
    }

    public void setRunBash(String bashName){
        this.runApp = bashName;
    }

    public void renderCommand(){
        String temp_command = os.getCreatecommand();
        temp_command = temp_command.replace("<|FILE_DIR|>",os.getInstallation_dir());
        temp_command = temp_command.replace("<|FILE_COMPILE|>",compileApp);
        temp_command = temp_command.replace("<|FILE_RUN|>",runApp);
        command = temp_command.split(";");
    }

    public void create(){
        int i = 1;
        for (String cmd:command) System.out.println("["+(i++)+"] : "+cmd);
    }

}

