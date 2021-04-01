package b2_loop_java.bai_tap;

import java.util.Scanner;

public class Image {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int width;
        int height;
        int bottom;
        int i;
        int j;
        int k;
        do {


            System.out.println("Menu:");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3.print isosceles triangle");
            System.out.println("4.print isosceles triangle");
            System.out.println("5.Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle");
                    System.out.println("Enter input width");
                    width = input.nextInt();
                    System.out.println("Enter input height");
                    height = input.nextInt();
                    for (i = 0; i < width; i++) {
                        for (j = 0; j < height; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Print the square triangle");
                    System.out.println("Enter input height");
                    height = input.nextInt();
                    System.out.println("enter input bottom");
                    bottom = input.nextInt();
                    for (i = 0; i <= height; i++) {
                        for (j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("print isosceles triangle");
                    System.out.println("Enter input height");
                    height = input.nextInt();
                    System.out.println("Enter input bottom");
                    bottom = input.nextInt();
                    for (i = 0; i < height; i++) {
                        for (j = 0; j < bottom - i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

            }
        } while (choice != 5);
    }
}

