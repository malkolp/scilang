package tool.component.register;

import tool.component.support.Regex;

import java.util.ArrayList;

public class Register{

    private static ArrayList<Token> tokenList;

    private Register(){}

    public static ArrayList<Token> getToken(){
        ArrayList<Token> toReturn = (ArrayList<Token>) tokenList.clone();
        resetTokenList();
        return toReturn;
    }

    public static void resetTokenList(){
        if (tokenList == null) tokenList = new ArrayList<>();
        tokenList.clear();
    }

    public static void end(){
        tokenList = null;
    }

    public static void register(String key){
        if (Regex.alphanum(key) | Regex.numConstant(key)){
            if (TokenTableManager.contains(key)){
                tokenList.add(TokenTableManager.token(key));
            } else {
                if (Regex.numConstant(key)){
                    if (Regex.doubletype(key)){
                        registerConstant(key,ValueHandler.DOUBLE_TYPE);
                    } else if (Regex.floattype(key)){
                        registerConstant(key,ValueHandler.FLOAT_TYPE);
                    } else {
                        registerConstant(key,ValueHandler.INT_TYPE);
                    }
                } else if (Regex.identifier(key)) {
                    registerIdentifier(key);
                } else {
                    registerError(key);
                }
            }
        } else {
            if (Regex.numConstant(key)){
                if (Regex.doubletype(key)){
                    registerConstant(key,ValueHandler.DOUBLE_TYPE);
                } else {
                    registerConstant(key,ValueHandler.FLOAT_TYPE);
                }
            } else {
                registerSymbol(key);
            }
        }
    }

    private static void registerSymbol(String key){
        if (TokenTableManager.contains(key)){
            tokenList.add(TokenTableManager.token(key));
        } else {
            if (key.length() > 1){
                StringBuilder key1 = new StringBuilder();
                String key2;
                if (key.length() > 2){
                    for (int i = 0; i < key.length()-1;i++){
                        key1.append(key.charAt(i));
                    }
                } else {
                    key1 = new StringBuilder(key.charAt(0)+"");
                }
                key2 = key.charAt(key.length()-1)+"";
                registerSymbol(key1.toString());
                registerSymbol(key2);
            } else {
                System.out.println(key);
                registerError(key);
            }
        }
    }

    public static void registerString(String key){
        Token token = TokenTableManager.token(TokenTableManager.CONSTANT).clone();
        token.setProperty1(ValueHandler.get().registerValue(key,ValueHandler.STRING_TYPE));
        tokenList.add(token);
    }

    private static void registerConstant(String key,double type){
        System.out.println(key+","+type);
        Token token = TokenTableManager.token(TokenTableManager.CONSTANT).clone();
        token.setProperty1(ValueHandler.get().registerValue(key, type));
        tokenList.add(token);
    }

    private static void registerIdentifier(String key){
        Token token = TokenTableManager.token(TokenTableManager.IDENTIFIER).clone();
        token.setProperty1(IdentifierHandler.get().registerID(key));
        tokenList.add(token);
    }

    private static void registerError(String key){
        //error HANDLER
        tokenList.add(TokenTableManager.token(TokenTableManager.ERROR));
    }
}
