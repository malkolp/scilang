package tool.component;

import java.util.ArrayList;

class Register{

    private static ArrayList<Double> tokenList;

    private Register(){}

    static ArrayList<Double> getToken(){
        ArrayList<Double> toReturn = (ArrayList<Double>) tokenList.clone();
        resetTokenList();
        return toReturn;
    }

    static void resetTokenList(){
        if (tokenList == null) tokenList = new ArrayList<>();
        tokenList.clear();
    }

    static void end(){
        tokenList = null;
    }

    static void register(String key){
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
                registerError(key);
            }
        }
    }

    static void registerString(String key){
        double value = ValueHandler.get().registerValue(key,ValueHandler.STRING_TYPE);
        tokenList.add(TokenTableManager.token(TokenTableManager.CONSTANT));
        tokenList.add(value);
    }

    private static void registerConstant(String key,double type){
        double value = ValueHandler.get().registerValue(key,type);
        tokenList.add(TokenTableManager.token(TokenTableManager.CONSTANT));
        tokenList.add(value);
    }

    private static void registerIdentifier(String key){
        double value = IdentifierHandler.get().registerID(key);
        tokenList.add(TokenTableManager.token(TokenTableManager.IDENTIFIER));
        tokenList.add(value);
    }

    private static void registerError(String key){
        //error HANDLER
        tokenList.add(TokenTableManager.token(TokenTableManager.ERROR));
    }
}
