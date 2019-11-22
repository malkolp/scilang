package tool.component;

import tool.component.api.Commander;
import tool.component.api.TokenProcessor;
import tool.component.lexer.Lexer;
import tool.component.lexer.Preprocessor;
import tool.component.register.Register;
import tool.component.register.TokenTableManager;
import tool.component.syntactic.Automata;

public class ToolManager {

    public Lexer lexer(){
        return Lexer.get();
    }

    public Automata automata(){return Automata.get();}

    public Preprocessor preprocessor(){
        return Preprocessor.get();
    }

    public TokenProcessor tokenProcessor(){ return TokenProcessor.get(); }

    public Commander commander(){return Commander.get();}

    public TokenTableManager tokenTableManager(){return TokenTableManager.get();}

    public void init(){
        TokenProcessor.get();
        TokenTableManager.get();
        Lexer.get();
        Register.resetTokenList();
    }

    public void end(){
        Lexer.end();
        Preprocessor.end();
        TokenTableManager.end();
        TokenProcessor.end();
        Register.end();
        Automata.end();
        Commander.end();
    }

    public void end(Object obj){
        if (obj == Lexer.get()) Lexer.end();
        else if (obj == Preprocessor.get()) Preprocessor.end();
        else if (obj == TokenProcessor.get()) TokenProcessor.end();
        else if (obj == TokenTableManager.get()) TokenTableManager.end();
        else if (obj == Automata.get()) Automata.end();
        else  if (obj == Commander.get()) Commander.end();
    }

}
