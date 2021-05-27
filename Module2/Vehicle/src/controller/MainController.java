package controller;

import com.introductiontojava.AddNewVehicle;
import com.introductiontojava.DeleteVehicle;
import com.introductiontojava.ShowVehicle;
import exception.SeaControlException;
import service.VehicleServiceImpl;

import java.util.Scanner;

public class MainController {
    public static void mainMenu(){
        Scanner input =new Scanner(System.in);
        String choose=null;
        do{
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát.");
            System.out.println("nhập lựa chọn của bạn:");
            choose=input.nextLine();
            switch (choose){
                case "1":
                    AddNewVehicle.menuAddNewVehicle();
                    break;
                case "2":
                    ShowVehicle.menuShowVehicle();
                    break;
                case "3":
                    try {
                        DeleteVehicle.menuDeleteVehicle();
                    } catch (SeaControlException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("Bạn đã thoát...!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn nhập sai vui lòng nhập lại...!");
                    break;
            }
        }while (choose!="4");

    }
}
