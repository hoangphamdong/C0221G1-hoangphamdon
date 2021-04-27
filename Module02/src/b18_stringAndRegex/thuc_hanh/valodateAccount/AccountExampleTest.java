package b18_stringAndRegex.thuc_hanh.valodateAccount;

import java.util.Scanner;

public class AccountExampleTest {


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Account");
        String Account = input.nextLine();
        boolean isvalid = AccountExample.validate(Account);
        System.out.println("Account is " + Account + " is valid: " + isvalid);


    }
}
