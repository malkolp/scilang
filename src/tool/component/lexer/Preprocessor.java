package tool.component.lexer;

public class Preprocessor {

    private static Preprocessor instance;

    private Preprocessor(){}

    private static void init(){
        if (instance == null) instance = new Preprocessor();
    }

    public static Preprocessor get(){
        init();
        return instance;
    }

    public static void end(){
        instance = null;
    }
}
