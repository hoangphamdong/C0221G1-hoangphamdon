package b18_stringAndRegex.bai_tap.validataNumberPhone;

import java.util.Scanner;

public class numberPhoneValidateTest {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Nhập số điện thoại: ");
        String numberPhone=input.nextLine();
        boolean isValid=NumberPhoneValidate.validate(numberPhone);
        System.out.println("Number Phone is "+numberPhone+"is valid: "+isValid);
    }

}
