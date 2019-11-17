package tool.component.register;

public class Token implements Cloneable{
    private String key;
    private double value;
    private double precedence;
    private double property1;
    private double property2;

    public Token(String key,double value,double precedence, double property1,double property2){
        this.key = key;
        this.value = value;
        this.precedence = precedence;
        this.property1 = property1;
        this.property2 = property2;
    }

    public Token clone(){
        try {
            return (Token) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setProperty1(double property1){
        this.property1 = property1;
    }

    public void setProperty2(double property2){
        this.property2 = property2;
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

    public double getProperty1() {
        return property1;
    }

    public double getProperty2() {
        return property2;
    }
}