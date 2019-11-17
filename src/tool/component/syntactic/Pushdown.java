package tool.component.syntactic;

import tool.component.register.Token;

class Pushdown {

    private static Pushdown instance;
    private Node terminator,top;
    private Token constraint;

    private Pushdown(){
        constraint = new Token("$",0,0,0,0);
        terminator = new Node(constraint,null);
        top = terminator;
    }

    private static void init(){
        if (instance == null) instance = new Pushdown();
    }

    static Pushdown get(){
        init();
        return instance;
    }

    void push(Token n){
        top = new Node(n,top);
    }

    Token pop(){
        if (top == terminator)
            return terminator.getToken();
        Token tkn = top.getToken();
        Node temp = top.getBottom();
        top = null;
        top = temp;
        return tkn;
    }

    Token getConstraint() {
        return constraint;
    }
}

class Node{
    private Token token;
    private Node bottom;

    Node(Token token, Node bottom){
        this.token = token;
        this.bottom = bottom;
    }

    Node getBottom() {
        return bottom;
    }

    Token getToken() {
        return token;
    }
}
