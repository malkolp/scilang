import tool.Sci;
import tool.component.api.TokenProcessor;
import tool.component.lexer.Lexer;
import tool.component.register.Token;

public class Main {

    public static void main(String[] args) {
        Sci.getComponent().init();
        TokenProcessor tp = Sci.getComponent().tokenProcessor();
        Lexer lx = Sci.getComponent().lexer();

        tp.load("token.txt");
        lx.lex("a = b + c - d;");

        for (Token token:lx.getToken()){
            System.out.print("["+token.getKey()+"]");
        }
    }

}
