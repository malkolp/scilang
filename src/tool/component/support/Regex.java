package tool.component.support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private Regex(){}

    public static boolean alphanum(char chr){
        String s = ""+chr;
        Pattern p = Pattern.compile("^[\\w$]+");
        Matcher m = p.matcher(s);
        return m.find();
    }

    public static boolean alphanum(String str){
        if (str.equals("")) return true;
        Pattern p = Pattern.compile("^[\\w$]+$");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static boolean numeric(char chr){
        String str = chr+"";
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static boolean numeric(String str){
        Pattern p = Pattern.compile("^[\\d]+$");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static boolean decimal(String str){
        Pattern p = Pattern.compile("^[\\d]+.?[\\d]+$|^[\\d]+$");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static boolean is_F_or_D(char chr){
        if (chr == 'f') return true;
        return chr == 'd';
    }

    public static boolean isDot(char chr){
        return chr == '.';
    }

    public static boolean lastDot(String str){
        return str.charAt(str.length()-1) == '.';
    }

    public static boolean quoteMarks(char chr){
        return chr == '\"';
    }

    public static boolean escaped(String str){
        if (str.length() < 1) return false;
        return str.charAt(str.length() - 1) == '\\';
    }

    public static boolean isSpace(char chr){
        return chr == ' ';
    }

    public static boolean isNotEmpty(String str){
        return !str.equals("");
    }

    public static boolean numConstant(String str){
        Pattern p = Pattern.compile("^[\\d]+[.]?[\\d]+[fd]?$|^[\\d]+[fd]?$");
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static boolean identifier(String key){
        Pattern p = Pattern.compile("^[_$]+[\\w$]+$|^[a-zA-Z$]+[\\w]*$");
        Matcher m = p.matcher(key);
        return m.find();
    }

    public static boolean keyword(String key){
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        Matcher m = p.matcher(key);
        return m.find();
    }

    public static boolean symbol(String key){
        Pattern p = Pattern.compile("^[^\\w]+$");
        Matcher m = p.matcher(key);
        return m.find();
    }


    public static boolean doubletype(String value){
        Pattern p = Pattern.compile("^[\\d]+[.][\\d]+[d]?$|^[\\d]+d$");
        Matcher m = p.matcher(value);
        return m.find();
    }

    public static boolean floattype(String value){
        Pattern p = Pattern.compile("^[\\d]+[.][\\d]+[f]$|^[\\d]+f$");
        Matcher m = p.matcher(value);
        return m.find();
    }

    public static String importReader(String key,String text){
        return "";
    }
}
