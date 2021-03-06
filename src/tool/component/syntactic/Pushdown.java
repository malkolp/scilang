package tool.component.syntactic;

import tool.component.register.Token;

class Pushdown {

    private static Pushdown instance;
    private Node terminator,top;
    private Token constraint;
    private int pointSwitch;

    private Pushdown(){
        constraint = new Token("$",0,0,0,0);
        terminator = new Node(constraint,null);
        top = terminator;
        pointSwitch = 0;
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
        pointSwitch = 0;
    }

    void push(Grammar n) {
        top = new Node(n,top);
        pointSwitch = 1;
    }

    Object pop(){
        Object obj;
        if (top == terminator)
            return terminator.getToken();
        obj = top.getToken();
        Node temp = top.getBottom();
        top = null;
        top = temp;
        return obj;
    }

    Object peek(){
        return top;
    }

    int getPointSwitch(){
        return pointSwitch;
    }

    Token getConstraint() {
        return constraint;
    }
}

class Node{
    private Token token;
    private Grammar grammar;
    private Node bottom;

    Node(Token token, Node bottom){
        this.token = token;
        this.bottom = bottom;
    }

    Node(Grammar token, Node bottom){
        this.grammar = token;
        this.bottom = bottom;
    }

    Node getBottom() {
        return bottom;
    }

    Object getToken() {
        if (token == null)
            return grammar;
        return token;
    }

}
