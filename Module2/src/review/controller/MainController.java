package review.controller;

import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chào mừng bạn đến với chương trình của chúng tôi.");
        while (true) {
            System.out.println("Menu của quý khách bào gồm:");
            System.out.println("1. Thêm mới");
            System.out.println("2. Sửa");
            System.out.println("3. Xoa");
            System.out.println("4. Danh sách");
            System.out.println("5. Tìm kiếm");
            System.out.print("Mời quý khách lựa chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                default:
                    System.out.println("Bạn lựa chọn sai. yêu cầu chọn lại");
            }
        }
    }
}
