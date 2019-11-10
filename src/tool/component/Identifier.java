package tool.component;

class Identifier {

    //attribute[0] = inited (0.0 not, 0.1 yet)
    //attribute[1] = valueKey
    //attribute[2] = dataTypekey

    private String identifier;
    private double[] attribute;

    Identifier(String identifier){
        this.identifier = identifier;
        attribute = new double[3];
        attribute[0] = 0;
        attribute[1] = 0;
        attribute[2] = 0;
    }

    void setInited(double init){
        this.attribute[0] = init;
    }

    void setValueKey(double valueKey){
        this.attribute[1] = valueKey;
    }

    void setDataTypekey(double dataTypekey){
        this.attribute[2] = dataTypekey;
    }


    String getIdentifier(){
        return identifier;
    }

    double[] getAttribute(){
        return attribute;
    }
}
