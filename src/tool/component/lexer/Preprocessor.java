package tool.component.lexer;

import tool.component.support.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Preprocessor {

    private static Preprocessor instance;
    private HashMap<String,Boolean> readMemory;
    private StackSource source;
    private String code;

    private Preprocessor(){
        readMemory = new HashMap<>();
        source = new StackSource();
        reset();
    }

    private static void init(){
        if (instance == null) instance = new Preprocessor();
    }

    public static Preprocessor get(){
        init();
        return instance;
    }

    public static void end(){
        instance = null;
    }

    public void reset(){
        code = "";
        readMemory.clear();
    }

    public String getCode(){return code;}

    public void launch(String url){
        readChild(url);
        readMemory.clear();
    }

    private void readChild(String file_url){
        if (!readMemory.containsKey(file_url)){
            readMemory.put(file_url,true);
            source.push();
            File file = new File(file_url);
            try {
                FileInputStream is = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                String processed;
                while ((line = reader.readLine()) != null){
                    source.peek(line);
                    if (!(processed = Regex.importReader("use",line)).equals("")) readChild(processed);
                }
                reader.close();
                code = code + source.pop();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}

class StackSource{

    private Node pointer;

    StackSource(){
        pointer = null;
    }

    void push(){
        Node n = new Node();
        n.setBottom(pointer);
        pointer = n;
    }

    String pop(){
        if (pointer != null){
            String s = pointer.getSource_code();
            pointer = pointer.getBottom();
            return s;
        }
        return "";
    }

    void peek(String code){
        pointer.add_code(code);
    }
}

class Node{

    private Node bottom;
    private String source_code;

    Node(){
        bottom = null;
        source_code = "";
    }

    void setBottom(Node bottom) {
        this.bottom = bottom;
    }

    void add_code(String source_code) {
        this.source_code = this.source_code + source_code;
    }

    Node getBottom() {
        return bottom;
    }

    String getSource_code() {
        return source_code;
    }
}