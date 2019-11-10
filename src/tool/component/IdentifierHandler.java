package tool.component;

import java.util.HashMap;

class IdentifierHandler {

    private static double identifierCount;
    private static IdentifierHandler instance;
    private static HashMap<Double,Identifier> identifierTable;

    private IdentifierHandler(){
        identifierCount = 0;
        identifierTable = new HashMap<>();
    }

    private static void init(){if (instance == null)instance = new IdentifierHandler();}

    static IdentifierHandler get(){
        init();
        return instance;
    }

    double registerID(String id){
        double key = generateKey();

        identifierTable.put(key,new Identifier(id));

        return key;
    }

    private static double generateKey(){
        identifierCount = identifierCount + 0.1;
        return identifierCount;
    }
}
