package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static final String SEA_CONTROL_TRUCK_REGEX = "[\\d]{2}C-[\\d]{3}.[\\d]{2}";
    public static final String SEA_CONTROL_CAR_REGEX = "[\\d]{2}[A|B]-[\\d]{3}.[\\d]{2}";
    public static final String SEA_CONTROL_MOTORCYCLE_REGEX = "[\\d]{2}-[w]{1}[\\d]{1}-[\\d]{3}.[\\d]{2}";

    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isValidRegex(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("biển kiểm soát không đúng "  );
        }
        return flag;
    }
}



