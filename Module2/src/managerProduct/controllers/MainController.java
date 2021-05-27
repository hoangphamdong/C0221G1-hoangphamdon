package managerProduct.controllers;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import managerProduct.exception.ChoiceException;
import managerProduct.exception.IdNotFoundException;
import managerProduct.models.Product;
import managerProduct.service.ProductService;
import managerProduct.service.ProductServiceImpl;

import java.util.Scanner;

public class MainController {
    private static Scanner input = new Scanner(System.in);
    static ProductService productService = new ProductServiceImpl();
    private static boolean isExit;

    public static void menu() {
        boolean check = true;
        do {
            System.out.println(" 1:thêm sản phẩm mới" +
                    "\n 2:hiển thị sản phẩm" +
                    "\n 3:xóa sản phẩm theo id" +
                    "\n 4:Exit");
            switch (input.nextInt()) {
                case 1: {
                    productService.addProduct();
                    break;
                }
                case 2: {
                    displayProduct();
                    break;
                }
                case 3: {
                    System.out.println("Enter id want delete");
                    int id =input.nextInt();
                    try {
                        productService.delete(id);
                    } catch (IdNotFoundException e) {
                        e.printStackTrace();
                    }break;
                } case 4:{
                    check=false;
                    break;
                }
            }
        }while (check);
    }
    public static void displayProduct(){
        for(Product product:productService.gatAll()){
            product.showInfo();
        }
    }
}


//    public static void menu() {
//        while (true) {
//            int choice;
//            try {
//                do {
//                    System.out.println("Main Menu:\n" +
//                            "1.\tAdd new product.\n" +
//                            "2.\tShow product.\n" +
//                            "3.\tDelete product.\n" +
//                            "4.\tEdit product.\n" +
//                            "5.\tExit.");
//                    System.out.println("Enter Your Choice:");
//                    choice = input.nextInt();
//                    if (choice < 1 || choice > 5) {
//                        throw new ChoiceException();
//                    } else {
//                        switch (choice) {
//                            case 1:
//                                productService.addProduct();
//                                break;
//                            case 2:
//                               displayProduct();
//                                break;
//                            case 3:
//                                System.out.println("List Product:");
//                                productService.gatAll();
//                                System.out.println("Please input id delete:");
//                                int id = input.nextInt();
//                                try {
//                                    productService.delete(id);
//                                } catch (IdNotFoundException e) {
//                                    e.printStackTrace();
//                                }
//                                break;
//                            case 4:
//                                break;
//                            case 5:
//                                System.out.println("BẠn Đã thoát..!");
//                                isExit = true;
//                        }
//                    }
//                } while (choice != 5);
//            } catch (NumberFormatException e) {
//                System.out.println("Vui lòng Nhập số nguyên..!");
//            } catch (ChoiceException e) {
//                System.out.println(e.getMessage());
//            }
//            if (isExit) {
//                break;
//            }
//        }
//
//    }public static void displayProduct(){
//        for(Product product:productService.gatAll()){
//            product.showInfo();
//        }
//    }







