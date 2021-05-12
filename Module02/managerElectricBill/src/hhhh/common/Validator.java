package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String CODE_CUSTOMER_VN="^(KHVN)-\\d{5}$";
    public static final String CODE_CUSTOMER_NN="^(KHNN)-\\d{5}$";
    public static final String Type_CUSTOMER="^(Sinh hoạt||Kinh doanh||Sản xuất)";

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
