package tool.component;

import java.util.HashMap;

class ValueHandler {

    static final double NULL_TYPE = 0.1;
    static final double INT_TYPE = 0.2;
    static final double DOUBLE_TYPE = 0.3;
    static final double FLOAT_TYPE = 0.4;
    static final double STRING_TYPE = 0.5;

    private static double valueCount;
    private static ValueHandler instance;
    private static HashMap<Double,Value> valueTable;

    private ValueHandler(){
        valueCount = 0;
        valueTable = new HashMap<>();
    }

    private static void init(){
        if (instance == null) instance = new ValueHandler();
    }

    static ValueHandler get(){
        init();
        return instance;
    }

    double registerValue(String value,double type){
        double key = generateKey();

        valueTable.put(key,new Value(value,type));

        return key;
    }

    private static double generateKey(){
        valueCount = valueCount + 0.1;
        return valueCount;
    }
}
