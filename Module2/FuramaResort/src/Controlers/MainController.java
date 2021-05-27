package Controlers;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                do {
                    System.out.println("Main Menu:\n" +
                            "1.\t Add New Services\n" +
                            "2.\tShow Services\n" +
                            "3.\tAdd New Customer\n" +
                            "4.\tShow Information of Customer\n" +
                            "5.\tAdd New Booking\n" +
                            "6.\tShow Information of Employee\n" +
                            "7.\tExit");
                    System.out.println("Enter Your Choice");
                    choice = Integer.parseInt(input.nextLine());
                    if (choice < 1 || choice > 7) {
                        System.out.println("Vui Lòng nhập từ 1-->7");
                    } else {
                        switch (choice) {
                            case 1:
                                AddNewServices.addNewServices();
                                break;
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                System.out.println("Bạn Đã Thoát");
                                System.exit(0);
                                break;
                        }
                    }
                } while (choice != 7);
            } catch (NumberFormatException e) {
                System.out.println("Nhập Số nguyên..!");

            }
        }
    }
}

