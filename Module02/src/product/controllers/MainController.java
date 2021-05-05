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
        int choose = 0;
        while (true) {
            try {
                do {

                    System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                            "Chọn chức năng:\n" +
                            "1. Thêm mới phương tiện.\n" +
                            "2. Hiện thị phương tiện\n" +
                            "3. Xóa phương tiện\n" +
                            "4. Thoát\n");
                    System.out.println("Enter Your Choose:");
                    choose = Integer.parseInt(input.nextLine());
                    if (choose < 1 || choose > 4) {
                        System.out.println("Vui lòng nhập từ 1-->4");
                    } else {
                        switch (choose) {
                            case 1:
                                productService.addNewProduct();
                                break;
                            case 2:
                                productService.getAll();
                                break;
                            case 3:
                                break;
                            case 4:
                                System.out.println("Bạn Đã thoát...!");
                                System.exit(0);
                                break;

                        }
                    }

                } while (choose != 4);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên");
            }
        }
    }
}
