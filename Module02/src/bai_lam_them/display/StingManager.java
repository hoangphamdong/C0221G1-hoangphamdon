package bai_lam_them.display;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StingManager {
    public static void addVehicle() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println(" 1.Thêm xe tải\n" +
                "2.Thêm oto\n" +
                "3.Thêm xe máy");
        System.out.println("Chọn thêm mới phương tiện:");

        try {
            int choiceAdd = input.nextInt();
            MethodChoiceException.choiceMenu(choiceAdd);
            switch (choiceAdd) {
                case 1:
                    System.out.println("Nhập biển kiểm soát:");
                    String bks1 = input.nextLine();
                    String bks = input.nextLine();
                    System.out.println("Nhập Tên Sản Xuất:");
                    String tsx = input.nextLine();
                    System.out.println("Nhập năm Sản Xuât:");
                    int year = Integer.parseInt(input.nextLine());
                    System.out.println("Chủ sở hữu:");
                    String csh = input.nextLine();
                    System.out.println("trọng tải:");
                    String tt = input.nextLine();
                    PhuongTienGiaoThong xetai = new Xetai(bks, tsx, year, csh, tt);
                    FileWriter fileWriter = new FileWriter("D:\\C0221G1-hoangphamdon1\\Module02\\src\\bai_lam_them\\file\\xeTai.csv");
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    String line = null;

            }
        } catch (IllegalChoiceException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("nhập số nguyên");
        }
    }
    public static void displayVehicle(){
        Scanner input = new Scanner(System.in);
        System.out.println(
                "1.Hiển thị xe tải \n" +
                "2.Hiển thị Oto\n" +
                "3.Hiển thị xe máy");
        System.out.println("Chọn hiển thị phương tiện:");
        int choiceDisplay=input.nextInt();
        try {
            int choiceAdd = input.nextInt();
            MethodChoiceException.choiceMenu(choiceAdd);
            switch (choiceDisplay) {
                case 1:
                    break;
            }
        } catch (IllegalChoiceException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("nhập số nguyên");
        }
    }
}
