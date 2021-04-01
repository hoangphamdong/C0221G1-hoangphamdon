package b1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumberConverWord {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String display ="";
        System.out.println("Enter number");
        int num=input.nextInt();
        switch (num){
            case 1:
                display="một";
                break;
            case 2:
                display="hai";
                break;
            case 3:
                display="ba";
                break;
        }
        System.out.printf(display);
    }
}
