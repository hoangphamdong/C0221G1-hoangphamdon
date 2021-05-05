package Controlers;

import Views.addNewService.AddNewHouse;
import Views.addNewService.AddNewRoom;
import Views.addNewService.AddNewVilla;

import java.util.Scanner;

public class AddNewServices {
    static Scanner input = new Scanner(System.in);

    public static void addNewServices() {
        int choice;
        boolean check = false;
        while (true) {
            try {
                do {
                    System.out.println("Add new services:\n" +
                            "1.\tAdd New Villa\n" +
                            "2.\tAdd New House\n" +
                            "3.\tAdd New Room\n" +
                            "4.\tBack to menu\n" +
                            "5.\tExit.");
                    System.out.println("Enter Choice Add new services");
                    choice = Integer.parseInt(input.nextLine());
                    if (choice < 1 || choice > 5) {
                        System.out.println("Vui Lòng Nhập từ 1-->5");
                    } else {
                        switch (choice) {
                            case 1:
                                AddNewVilla.addNewVilla();
                                break;
                            case 2:
                                AddNewHouse.addNewHouse();
                                break;
                            case 3:
                                AddNewRoom.addNewRoom();
                            case 4:
                                System.out.println("Bạn Đã quay lại Menu main");
                                check=true;
                                break;
                            case 5:
                                System.out.println("Bạn Đã Thoat..!");
                                System.exit(0);
                                break;
                        }
                    }
                }while (choice!=4);
            } catch (NumberFormatException e) {
                System.out.println("Vui Lòng Nhập số nguyên..!");
            } if (check) {
                break;
            }
        }
    }

}

