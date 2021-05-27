package b18_stringAndRegex.bai_tap.validateNameClass;

import b18_stringAndRegex.thuc_hanh.valodateAccount.AccountExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameValidate {
    private static final String ACCOUNT_REGEX="^[CAP]\\w{4}[GHIKLM]";
    public ClassNameValidate(){

    }
    public static boolean validate(String regex){
        Pattern pattern =Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
