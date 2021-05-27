package b15_exceptionAndDebug.thuc_hanh.numberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        while (true){
            try {
                Scanner input=new Scanner(System.in);
                System.out.println("Hãy nhập x: ");
                int x=input.nextInt();
                System.out.println("Hãy nhập y: ");
                int y=input.nextInt();
                Calculate.calculate(x,y);
                break;
            }catch (InputMismatchException e){
                System.out.println("phải nhập số nguyên");
            }
        }


    }
}
