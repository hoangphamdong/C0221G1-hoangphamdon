package furamaResort.Commons;

import furamaResort.Exception.*;

import java.time.Year;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static final String SERVICE_CODE_REGEX = "SV(VL|HO|RO)-[\\d]{4}";
    public static final String SERVICE_NAME_REGEX = "[A-Z][a-z]*";
    public static final String ID_CARD_REGEX = "[\\d]{3} [\\d]{3} [\\d]{3}";
    public static final String DATE_REGEX = "[\\d]{2}/[\\d]{2}/[\\d]{4}";

    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isValidRegex(String str, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);
        boolean flag = matcher.matches();
        if (!flag) {
            System.out.println("Input not matching " + regex);
        }
        return flag;
    }

    public static boolean isMoreThan(double number, double destNumber) {
        boolean flag = number > destNumber;

        if (!flag) {
            System.out.println("Input is not more that " + destNumber);
        }
        return flag;
    }

    public static boolean isMoreThan(double number, double startNumber, double endNumber) {
        boolean flag = number > startNumber && number < endNumber;

        if (!flag) {
            System.out.println("Input is not in (" + startNumber + "," + endNumber + ")");
        }
        return flag;
    }

    public static boolean isValidExtraServiceName(String extraServiceName) {
        String[] list = {"massage", "karaoke", "food", "drink", "car"};
        boolean flag = Arrays.asList(list).contains(extraServiceName);
        if (!flag) {
            System.out.println("Extra service name is not in list service..!");
        }
        return flag;
    }

    public static void isValidFullName(String fullName) throws NameException {

        String[] fullNameElements = fullName.split(" ");

        for (String element : fullNameElements) {
            if (Character.isLowerCase(element.charAt(0))) {
                throw new NameException();
            }
        }
        for (int i = 0; i < fullName.length() - 1; i++) {
            if (fullName.charAt(i) == ' ' && fullName.charAt(i + 1) == ' ') {
                throw new NameException();
            }
        }
    }

    public static void isValidEmail(String email) throws EmailException {
        int posA = email.indexOf("@");

        if (posA < 0) {
            throw new EmailException();
        }

        int countA = 0;
        int countPoint = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                countA++;
            } else if (email.charAt(i) == '.') {
                countPoint++;
            }

            if (countA >= 2) {
                throw new EmailException();
            }
        }
        if (countPoint == 0) {
            throw new EmailException();
        }
    }

    public static void isValidGender(String gender) throws GanderException {
        String[] list = {"male", "female", "unknown"};
        if (!Arrays.asList(list).contains(gender.toLowerCase())) {
            throw new GanderException();
        }
    }

    public static void isValidCard(String idCard) throws IdCardException {
        if (!isValidRegex(idCard, Validators.ID_CARD_REGEX)) {
            throw new IdCardException();
        }
    }

    public static void isValidBirthday(String birthday) throws BirthdayException {
        if (isValidRegex(birthday, Validators.DATE_REGEX)) {
            int birYear = Integer.parseInt(birthday.split("/")[2]);
            int curYear = Year.now().getValue();

            if (birYear <= 1900 || curYear - birYear < 18) {
                throw new BirthdayException();
            }
        } else {
            throw new BirthdayException();
        }
    }
}

