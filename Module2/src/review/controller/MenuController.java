package review.controller;

import java.util.Scanner;

public class MenuController {
    public void menuAdd() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bạn muốn thêm mới: ");
            System.out.println("1. Học sinh");
            System.out.println("2. Giáo viên");
            System.out.println("3. Back");
            System.out.println("4. Exit");
            try {
                System.out.print("Mời bạn nhập lự chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return;
                    case 2:
                    case 3:
                        return;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Bạn nhập lựa chon sai. Yêu cầu nhập lại!");
                }
            } catch (Exception e) {
                System.out.println("Bạn nhập lựa chon sai. Yêu cầu nhập lại!");
            }

        }
    }
}
