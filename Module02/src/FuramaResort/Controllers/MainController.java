package FuramaResort.Controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainController {
    public static void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        try {
            int choice;
            do {

                System.out.println("Choice Manager Menu:\n" +
                        "1.Add New Services\n" +
                        "2.Show Services\n" +
                        "3.Add New Customer\n" +
                        "4.Show Information of Customer\n" +
                        "5.Add New Booking\n" +
                        "6.Show Information of Employee\n" +
                        "7.Exit");
                System.out.println("Enter choice:");
                choice = input.nextInt();
            }while (choice!=7);
        } catch (InputMismatchException e) {
            System.out.println("Phải nhập số nguyên !");
        }

    }
}
