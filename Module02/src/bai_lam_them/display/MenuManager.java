package bai_lam_them.display;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {
    public static void main(String[] args) throws IOException {
        boolean check = true;

        int choice = 0;
        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG \n" +
                        "Chọn chức năng:\n" +
                        "1.Thêm mới phương tiện\n" +
                        "2.Hiển thị phương tiện\n" +
                        "3.Xóa phương tiện\n" +
                        "4.Thoát");
                System.out.println("Chọn chức năng:");
                choice = input.nextInt();
                MethodChoiceException.choiceMenu(choice);
                switch (choice) {
                    case 1:
                        StingManager.addVehicle();
                        break;
                    case 2:
                        StingManager.displayVehicle();
                        break;

                }
            } catch (IllegalChoiceException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Nhập số nguyên");
            }
            if (choice == 4) {
                System.out.println("Thoát.");
            }
        } while (choice != 4);



    }
}


