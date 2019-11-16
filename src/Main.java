import tool.Sci;
import tool.component.TokenProcessor;

public class Main {

    public static void main(String[] args) {
        Sci.getComponent().init();
        TokenProcessor tp = Sci.getComponent().tokenProcessor();
    }

}
