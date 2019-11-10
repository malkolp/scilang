package tool.component;

public class Preprocessor {

    private static Preprocessor instance;

    private Preprocessor(){}

    private static void init(){
        if (instance == null) instance = new Preprocessor();
    }

    static Preprocessor get(){
        init();
        return instance;
    }

    static void end(){
        instance = null;
    }
}