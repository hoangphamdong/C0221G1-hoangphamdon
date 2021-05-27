package quanLyDanhBa.comom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String SDT_REGEX="^\\d{10}$";
    public static final String EMAIL_REGEX="";

    private static Pattern pattern;
    private static Matcher matcher;



    public static boolean isValidRegex(String str,String regex){

        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(str);
        boolean flag=matcher.matches();
        if(!flag){
            System.out.println("mã nhập sai...!");
        }return flag;
    }
}
