import tool.Sci;
import tool.component.api.GrammarProcessor;
import tool.component.api.TokenProcessor;
import tool.component.register.Token;
import tool.component.register.TokenTableManager;
import tool.component.syntactic.GrammarTableManager;

/*
    Author  : Malko
    Project : Scilang

*/

public class Main {

    public static void main(String[] args) {
        //CODE YOUR IMAGINATION HERE
        Sci.getComponent().init();
        TokenProcessor    tp = Sci.getComponent().tokenProcessor();
        GrammarProcessor  gp = Sci.getComponent().grammarProcessor();

        tp.load("token.txt");

        gp.save("grammar.txt");
    }


}
