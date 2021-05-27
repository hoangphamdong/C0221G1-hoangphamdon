package product.controllers;

import b17_binaryFile.bai_tap.managerProduct.ManagerProduct;
import product.exception.IdNotFoundException;
import product.models.Product;
import product.services.ProductServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainController {
    static Scanner input = new Scanner(System.in);
    private static ProductServiceImpl productService = new ProductServiceImpl();

    public static void menu() throws IdNotFoundException {
        System.out.println("Chào mừng bạn đến với chương trình của chúng tôi.");
        while (true) {
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM:\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới sản phẩm.\n" +
                    "2. Hiện thị sản phẩm\n" +
                    "3. Xóa sản phảm\n" +
                    "4. Thoát\n");
            System.out.println("Enter Your Choose:");
            String choose = input.nextLine();
            switch (choose) {
                case "1":
                    productService.addNewProduct();
                    break;
                case "2":
                    productService.getAll();
                    break;
                case "3":
                    productService.getAll();
                    System.out.println("Please input your need delete:");
                    int id = Integer.parseInt(input.nextLine());
                    productService.delete(id);
                    System.out.println("You Had delete product have " + id);
                    System.out.println("After delete:");
                    productService.getAll();
                    break;
                case "4":
                    System.out.println("Bạn Đã thoát...!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn chọn sai..!");
            }
        }
    }
}
