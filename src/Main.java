import tool.Sci;
import tool.component.lexer.Preprocessor;

/*
    Author  : Malko
    Project : Scilang

*/

public class Main {

    public static void main(String[] args) {
        //CODE YOUR IMAGINATION HERE
        Sci.getComponent().init();
        Preprocessor pr = Preprocessor.get();
        pr.launch("token.txt");
    }

}
