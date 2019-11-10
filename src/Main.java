import tool.Sci;
import tool.component.Lexer;
import tool.component.TokenProcessor;
import tool.component.TokenTableManager;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Sci.getComponent().init();

        TokenProcessor tp = Sci.getComponent().tokenProcessor();
        tp.add("var");
        tp.add("fun");
        tp.add("+");
        tp.add("=");
        tp.add(";");
        tp.add("\"");
        tp.add("print");
        tp.save("token.txt");

        Lexer lexer = Sci.getComponent().lexer();
        lexer.lex("print \"string\";");

        ArrayList<Double> d = lexer.getToken();

        for(Double token:d)
            System.out.print("["+token+"]");
    }

}
