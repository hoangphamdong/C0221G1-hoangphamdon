package managerVehicle.controllers;

import managerVehicle.exception.SeaControlException;
import managerVehicle.services.FunctionVehicleImpl;

import java.util.Scanner;

public class MainControllers {
    private static Scanner input = new Scanner(System.in);
    private static boolean isExit;
    private static FunctionVehicleImpl functionVehicle=new FunctionVehicleImpl();

    public static void mainMenu() {
        String choose = null;
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát\n");
            System.out.println("Enter your Choose:");
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    functionVehicle.addNewVehicle();
                    break;
                case "2":
                    functionVehicle.showVehicle();
                    break;
                case "3":
                    System.out.println("Input sea control");
                    String seaControl=input.nextLine();
                    try {
                        functionVehicle.deleteVehicle(seaControl,"oto");
                    } catch (SeaControlException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("you had Exit..!");
                    isExit = true;
                    break;
            }
            if (isExit) {
                break;
            }
        } while (choose!="4");
    }
}

