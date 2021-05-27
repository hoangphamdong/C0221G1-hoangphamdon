package com.introductiontojava;

import common.StringUtil;
import service.VehicleServiceImpl;

import java.util.Scanner;

public class AddNewVehicle {
    private static VehicleServiceImpl vehicleService=new VehicleServiceImpl();
    private static Scanner input =new Scanner(System.in);
    public static void menuAddNewVehicle(){
        String choose=null;
        do {
            System.out.println("Thêm mới phương tiện:\n" +
                    "1. Thêm xe tải,\n" +
                    "2. Thêm ôtô, \n" +
                    "3. Thêm  xe máy.\n" +
                    "4. quay lại menu chính\n" +
                    "5. thoát.");
            System.out.println("Nhập lựa chọn của bạn:");
            choose=input.nextLine();
            switch (choose){
                case "1":
                    vehicleService.addNewVehicle(StringUtil.TRUCK);
                    break;
                case "2":
                    vehicleService.addNewVehicle(StringUtil.CAR);
                    break;
                case "3":
                    vehicleService.addNewVehicle(StringUtil.MOTORCYCLE);
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
