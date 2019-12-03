import tool.Sci;
import tool.component.lexer.Lexer;
import tool.component.lexer.Preprocessor;
import tool.component.syntactic.Automata;

/*
    Author  : Malko
    Project : Scilang

*/

public class Main {

    public static void main(String[] args) {
        //CODE YOUR IMAGINATION HERE
        Sci.getComponent().init();
        Sci.load("grammar.txt","token.txt");

        Preprocessor p = Sci.getComponent().preprocessor();
        Lexer lx       = Sci.getComponent().lexer();
        Automata au    = Sci.getComponent().automata();
        p.launch("code1.txt");
        lx.lex(p.getCode());
    }


}
