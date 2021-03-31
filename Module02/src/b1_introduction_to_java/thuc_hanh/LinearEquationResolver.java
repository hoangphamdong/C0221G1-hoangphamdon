package b1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants :");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b : ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        if (a != 0) {
            double solution =(c -b) / a;
            System.out.print("The solution is:" + solution);
        }
         else {
            if (b == 0) {
                System.out.print("The solution is all x!");

            }else {
                System.out.print("No solution!");
            }
        }
    }
}
