package b15_exceptionAndDebug.bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        while (true){

            try {
                Scanner input =new Scanner(System.in);
                System.out.println("input side 1");
                double side1=input.nextDouble();
                System.out.println("input side 2");
                double side2=input.nextInt();
                System.out.println("input side 3");
                double side3=input.nextInt();
                Triangle triangle=new Triangle(side1,side2,side3);
                break;

            }catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println("nhập số");
            }
        }
        System.out.println("Tam giác hợp lệ");
    }
}
