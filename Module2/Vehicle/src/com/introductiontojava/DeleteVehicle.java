package com.introductiontojava;

import common.StringUtil;
import exception.SeaControlException;
import service.VehicleServiceImpl;

import java.util.Scanner;

public class DeleteVehicle {
    private static VehicleServiceImpl vehicleService = new VehicleServiceImpl();
    private static Scanner input = new Scanner(System.in);

    public static void menuDeleteVehicle() throws SeaControlException {
        String choose = null;
        do {
            System.out.println("Xóa phương tiện:\n" +
                    "1. Xóa xe tải,\n" +
                    "2. Xóa ôtô, \n" +
                    "3. Xóa  xe máy.\n" +
                    "4. quay lại menu chính\n" +
                    "5. thoát.");
            System.out.println("Nhập lựa chọn của bạn:");
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("nhập biển số xe cần xóa:");
                    String seaControlTruck = input.nextLine();
                    vehicleService.delete(seaControlTruck,StringUtil.TRUCK);
                    System.out.println("Bạn đã xóa xe có biển kiểm soát "+seaControlTruck);
                    break;
                case "2":
                    System.out.println("nhập biển số xe cần xóa:");
                    String seaControlCar=input.nextLine();
                    vehicleService.delete(seaControlCar,StringUtil.CAR);
                    System.out.println("Bạn đã xóa xe có biển kiểm soát "+seaControlCar);
                    break;
                case "3":
                    System.out.println("nhập biển số xe cần xóa:");
                    String seaControlMotorcycle=input.nextLine();
                    vehicleService.delete(seaControlMotorcycle,StringUtil.MOTORCYCLE);
                    System.out.println("Bạn đã xóa xe có biển kiểm soát "+seaControlMotorcycle);
                    break;
                case "4":
                    System.out.println("Bạn đã quay lại menu chính..!");
                    return;
                case "5":
                    System.out.println("Bạn Đã thoát..!");
                    System.exit(0);
                default:
                    System.out.println("Ban nhập sai vui lòng nhập lại:");
                    break;
            }
        } while (choose != "5");
    }
}
