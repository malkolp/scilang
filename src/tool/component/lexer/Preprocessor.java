package tool.component.lexer;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

public class Preprocessor {

    private static Preprocessor instance;
    private String code;

    private Preprocessor(){
        reset();
    }

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

    public void reset(){
        code = "";
    }

    public String getCode(){return code;}

    public void launch(String url){

    }

}