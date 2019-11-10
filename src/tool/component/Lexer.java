package tool.component;

import java.util.ArrayList;

public class Lexer{

    private static Lexer instance;
    private static ArrayList<Double> token;

    private Lexer(){}

    private static void init(){
        if (instance == null) instance = new Lexer();
    }

    static Lexer get(){
        init();
        return instance;
    }

    static void end(){
        token = null;
        instance = null;
    }

    public void lex(String code){
        boolean stringToken = false;
        char point;
        String key = "";
        int iter = 0;

        while (iter < code.length()){
            point = code.charAt(iter);
            if (stringToken){
                if (Regex.quoteMarks(point) && !Regex.escaped(key)){
                    Register.registerString(key);
                    key = point+"";
                    Register.register(key);
                    key = "";
                    stringToken = false;
                }
                else {
                    key = key + point;
                }
            }
            else {
                if (Regex.isSpace(point)){
                    if (Regex.isNotEmpty(key)){
                        Register.register(key);
                        key = "";
                    }
                }
                else {
                    if (Regex.alphanum(point)){
                        if (Regex.alphanum(key)){
                            key = key + point;
                        }
                        else {
                            if (Regex.decimal(key) && Regex.is_F_or_D(point)){
                                key = key + point;
                            }
                            else if (Regex.lastDot(key) && Regex.numeric(point)){
                                key = key + point;
                            }
                            else {
                                Register.register(key);
                                key = point+"";
                            }
                        }
                    }
                    else {
                        if (Regex.quoteMarks(point) && !Regex.escaped(key)){
                            if (Regex.isNotEmpty(key)){
                                Register.register(key);
                            }
                            key = point+"";
                            Register.register(key);
                            key = "";
                            stringToken = true;
                        }
                        else {
                            if (Regex.alphanum(key)){
                                if (Regex.numeric(key) && Regex.isDot(point)){
                                    key = key + point;
                                }
                                else {
                                    if (Regex.isNotEmpty(key)){
                                        Register.register(key);
                                    }
                                    key = point+"";
                                }
                            }
                            else {
                                if (Regex.numConstant(key)){
                                    Register.register(key);
                                    key = point+"";
                                }
                                else {
                                    key = key + point;
                                }
                            }
                        }
                    }
                }
            }
            iter++;
        }
        if (Regex.isNotEmpty(key)){
            Register.register(key);
        }
        token = Register.getToken();
    }

    public void clearToken(){
        token.clear();
    }

    public ArrayList<Double> getToken(){
        return token;
    }

}
