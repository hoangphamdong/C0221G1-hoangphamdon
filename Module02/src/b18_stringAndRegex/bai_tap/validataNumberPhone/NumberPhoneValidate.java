package b18_stringAndRegex.bai_tap.validataNumberPhone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhoneValidate {
    private static final String ACCOUNT_REGEX="^\\([0-9]{2}\\)\\-\\([0][0-9]{9}\\)";

    public NumberPhoneValidate() {
    }
    public static boolean validate(String regex){
        Pattern pattern=Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
