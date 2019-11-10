package tool.component;

class Value {

    private String value;
    private double dataTypeKey;

    Value(String value,double dataTypeKey){
        this.value = value;
        this.dataTypeKey = dataTypeKey;
    }

    void setValue(String value){
        this.value = value;
    }

    void setDataTypeKey(double dataTypeKey){
        this.dataTypeKey = dataTypeKey;
    }

    String getValue(){
        return value;
    }

    double getDataTypeKey(){
        return dataTypeKey;
    }

}
