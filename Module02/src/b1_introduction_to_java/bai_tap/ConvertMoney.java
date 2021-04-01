package b1_introduction_to_java.bai_tap;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        final int RATE=23000;
        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter USA:");
        int usa=scanner.nextInt();
        int VND=usa*RATE;
        System.out.print("VND :");
        System.out.print(VND);
    }
}
