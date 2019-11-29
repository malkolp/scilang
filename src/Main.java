import tool.Sci;
import tool.component.api.TokenProcessor;
import tool.component.lexer.Lexer;
import tool.component.lexer.Preprocessor;
import tool.component.register.Token;

import java.util.ArrayList;
import java.util.Scanner;

/*
    Author  : Malko
    Project : Scilang

*/

public class Main {

    public static void main(String[] args) {
        //CODE YOUR IMAGINATION HERE
        Sci.getComponent().init();
        TokenProcessor tp = Sci.getComponent().tokenProcessor();
        Preprocessor pr = Sci.getComponent().preprocessor();
        Lexer lx = Sci.getComponent().lexer();

        tp.load("token.txt");
        pr.launch("code1.txt");
        System.out.println(pr.getCode());
        lx.lex(pr.getCode());
        for (Token tkn:lx.getToken())
            System.out.print("["+tkn.getKey()+"]");
    }


}
