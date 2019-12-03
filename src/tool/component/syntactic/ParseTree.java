package tool.component.syntactic;

import java.util.ArrayList;
import java.util.List;

class ParseTree {

    ArrayList<Node> tempChild;

    ParseTree(){
        tempChild = new ArrayList<>();
    }

    void addChild(String key){

    }

    class Node{
        private Node[] child;
        private String key;

        Node(Node[] child,String key){
            this.child = child;
            this.key   = key;
        }
    }

}

