package b18_stringAndRegex.bai_tap.validateNameClass;


import java.util.Scanner;

public class ClassNameValidateTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Account");
        String Account = input.nextLine();
        boolean isvalid = ClassNameValidate.validate(Account);
        System.out.println("Account is " + Account + " is valid: " + isvalid);
    }
}
