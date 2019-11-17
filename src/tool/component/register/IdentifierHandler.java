package tool.component.register;

import java.util.HashMap;

class IdentifierHandler {

    private static double identifierCount;
    private static IdentifierHandler instance;
    private static HashMap<Double,Identifier> identifierTable;
    private static HashMap<String,Double> identifierID;

    private IdentifierHandler(){
        identifierCount = 0;
        identifierTable = new HashMap<>();
        identifierID = new HashMap<>();
    }

    private static void init(){if (instance == null)instance = new IdentifierHandler();}

    static IdentifierHandler get(){
        init();
        return instance;
    }

    double registerID(String id){
        if (identifierID.containsKey(id))
            return identifierID.get(id);
        else {
            double key = generateKey();

            identifierTable.put(key,new Identifier(id));
            identifierID.put(id,key);

            return key;
        }
    }

    private static double generateKey(){
        identifierCount = Math.round((identifierCount + 0.1)*10)/10.0;
        return identifierCount;
    }
}