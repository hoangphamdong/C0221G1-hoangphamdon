package controllers;

import hhhh.servlice.ServiceCustomerImpl;

import java.util.Scanner;

public class MainController {
    private static Scanner input = new Scanner(System.in);
    static ServiceCustomerImpl serviceCustomer=new ServiceCustomerImpl();
    public static void mainMenu() {
        String choose = null;
        do {
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới khách hàng.\n" +
                    "2. Hiện thị thông tin khách hàng\n" +
                    "3. Tìm kiếm khách hàng\n" +
                    "4. Thêm mới hóa đơn\n" +
                    "5. Chỉnh sửa hóa đơn\n" +
                    "6. Hiện thị thông  tin chi tiết hóa đơn\n" +
                    "7. Thoát\n");
            System.out.println("nhập lựa chọn của bạn:");
            choose = input.nextLine();
            switch (choose){
                case "1":
                    AddNewCustomer.addNewCustomer();
                    break;
                case "2":
                    ShowInformation.showInformationCustomer();
                    break;
                case "3":
                    SearchCustomer.searchCustomer();
                    break;

                case "4":
                    serviceCustomer.addNewBill();
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    System.out.println("Bạn đã thoát...!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Bạn nhập sai vui lòng nhập lại......!");
                    System.exit(0);
                    break;
            }
        } while (choose != "7");
    }
}
