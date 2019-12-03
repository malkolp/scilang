package tool.component.syntactic;

public class Grammar implements Cloneable{

    private String key;
    private double value,precedence;

    public Grammar(String key, double value, double precedence){
        this.key = key;
        this.value = value;
        this.precedence = precedence;
    }

    public Grammar clone(){
        try {
            return (Grammar) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public double getValue() {
        return value;
    }

    public double getPrecedence() {
        return precedence;
    }
}
