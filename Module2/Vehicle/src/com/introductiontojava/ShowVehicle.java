package com.introductiontojava;

import common.StringUtil;
import service.VehicleServiceImpl;

import java.util.Scanner;

public class ShowVehicle {
    private static Scanner input=new Scanner(System.in);
    private static VehicleServiceImpl vehicleService=new VehicleServiceImpl();
    public static void menuShowVehicle(){
        String choose=null;
        do {
            System.out.println("Hiển thị phương tiện:\n" +
                    "1. Hiển thị xe tải,\n" +
                    "2. Hiển thị ôtô, \n" +
                    "3. Hiển thị  xe máy.\n" +
                    "4. quay lại menu chính\n" +
                    "5. thoát.");
            System.out.println("Nhập lựa chọn của bạn:");
            choose=input.nextLine();
            switch (choose){
                case "1":
                    vehicleService.showVehicle(StringUtil.TRUCK);
                    break;
                case "2":
                    vehicleService.showVehicle(StringUtil.CAR);
                    break;
                case "3":
                    vehicleService.showVehicle(StringUtil.MOTORCYCLE);
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
        }while (choose!="5");
    }
}
