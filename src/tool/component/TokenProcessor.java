package tool.component;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenProcessor {

    private static TokenProcessor instance;
    private static double idPoint;
    private static ArrayList<Token> tokenList;
    private static ArrayList<Token> added;

    private TokenProcessor(){
        idPoint = 0.3;
        tokenList = new ArrayList<>();
        added = new ArrayList<>();
    }

    private static void init(){
        if (instance == null)instance = new TokenProcessor();
    }

    static TokenProcessor get(){
        init();
        return instance;
    }

    static void end(){
        added = null;
        tokenList = null;
        instance = null;
        idPoint = 0;
    }

    public void add(String key){
        if (!TokenTableManager.contains(key) || Regex.isNotEmpty(key)){
            if (Regex.keyword(key)){
                idPoint = Math.round((idPoint + 0.1) * 100.0) / 100.0;
                added.add(new Token(key,idPoint));
                TokenTableManager.get().add(key,idPoint);
            } else {
                if (Regex.symbol(key)){
                    if (key.length() > 1){
                        StringBuilder id1 = new StringBuilder();
                        String id2 = "";

                        if (key.length() > 2){
                            for (int i = 0; i < key.length() -1; i++)
                                id1.append(key.charAt(i));
                        } else {
                            id1.append(key.charAt(0));
                        }
                        id2 = key.charAt(key.length()-1)+"";

                        if (!TokenTableManager.contains(id2)){
                            add(id2);
                        }
                        if (!TokenTableManager.contains(id1.toString())){
                            add(id1.toString());
                        }
                        double idkey1 = TokenTableManager.token(id1.toString());
                        double idkey2 = TokenTableManager.token(id2);
                        double new_idpoint = computeId(idkey1,idkey2);
                        added.add(new Token(key,new_idpoint));
                        TokenTableManager.get().add(key,idPoint);

                    } else {
                        idPoint = Math.round((idPoint + 0.1) * 100.0) / 100.0;
                        added.add(new Token(key,idPoint));
                        TokenTableManager.get().add(key,idPoint);
                    }
                }
            }
        }
    }

    public void load(String file_url){
        Pattern loader = Pattern.compile("^[\\d]+.[\\s]*\\|[\\s]*([a-zA-Z]+)[\\s]*\\|[\\s]*([\\d]+[.]?[\\d]*)$|^[\\d]+.[\\s]*\\|[\\s]*([!@#$%^&*()\\-+=|\\\\~`{\\[}\\]:;\"'<>?/,.]+)[\\s]*\\|[\\s]*([\\d]+[.]?[\\d]*)$");
        Matcher m;
        File file;
        try {
            file = new File(file_url);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tmp = "";
            String key = "";
            double id = 0;
            while ((tmp = reader.readLine())!= null){
                m = loader.matcher(tmp);
                if (m.find()){
                    key = m.group(1);
                    id  = Double.parseDouble(m.group(2));
                    tokenList.add(new Token(key,id));
                    TokenTableManager.get().add(key,id);
                }
            }
            idPoint = id;
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void save(String file_url){
        Thread thread = new Thread(() -> {
            tokenList.addAll(added);

            File file = new File(file_url);
            FileWriter writer;
            BufferedWriter bwriter;

            try{
                file.createNewFile();
                writer  = new FileWriter(file);
                bwriter = new BufferedWriter(writer);

                for (int i = 0 ; i < tokenList.size(); i++)
                    bwriter.write(write(i+1,tokenList.get(i).getKey(),tokenList.get(i).getValue()));

                bwriter.close();
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        });

        thread.start();
    }

    private String write(int index, String key, double id){
        return index+".\t| "+key+"\t| "+id+"\n";
    }

    private static double computeId(double id1, double id2){
        if (id1 <= id2){
            idPoint = Math.round(((id1 + id2) * 0.25 + (idPoint * 0.75)) * 100.0) / 100.0;
            return idPoint;
        }
        idPoint = Math.round(((id1 + id2) / 3.95 + (idPoint * 0.75)) * 100.0) / 100.0;
        return idPoint;
    }

}

class Token{
    private String key;
    private double value;

    Token(String key,double value){
        this.key = key;
        this.value = value;
    }

    String getKey() {
        return key;
    }

    double getValue() {
        return value;
    }
}