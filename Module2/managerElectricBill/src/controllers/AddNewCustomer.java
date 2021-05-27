package controllers;

import hhhh.common.StringUint;
import hhhh.servlice.ServiceCustomerImpl;

import java.util.Scanner;

public class AddNewCustomer {
    private static Scanner input=new Scanner(System.in);
   private static ServiceCustomerImpl serviceCustomer=new ServiceCustomerImpl();
    public static void addNewCustomer(){
        String choose= null;
        do {
            System.out.println("Thêm mới khách hàng\n" +
                    "1. Thêm khách hàng VN.\n" +
                    "2. Thêm khách hàng nước ngoài.\n" +
                    "3. Quay lại menu chính.\n" +
                    "4. Thoát.");
            System.out.println("Vui lòng nhập lựa chọn của bạn");
            choose=input.nextLine();
            switch (choose){
                case "1":
                    serviceCustomer.addNewCustomer(StringUint.CUSTOMER_VN);
                    break;
                case "2":
                    serviceCustomer.addNewCustomer(StringUint.CUSTOMER_NN);
                case "3":
                    return;
                case "4":
                    System.out.println("Bạn đã thoát...!");
                    System.exit(0);
                default:
                    System.out.println("Bạn nhập sai vui lòng nhập lại.");
            }
        }while (choose!="4");
    }
}
