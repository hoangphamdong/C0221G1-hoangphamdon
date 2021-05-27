package quanLyDanhBa.controller;


import quanLyDanhBa.service.QuanLyDanhBaImpl;

import java.util.Scanner;

public class MainController {
    private static Scanner input = new Scanner(System.in);
    private static QuanLyDanhBaImpl quanLyDanhBa = new QuanLyDanhBaImpl();

    public static void mainMenu() {

        String choose = null;
        do {
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ\n" +
                    "Chọn chức năng:\n" +
                    "1. Xem danh sách.\n" +
                    "2. Thêm mới\n" +
                    "3. Cập nhập\n" +
                    "4. Xóa\n" +
                    "5. Tìm kiếm\n" +
                    "6. Đọc từ file\n" +
                    "7.Ghi từ file\n" +
                    "8. Thoát\n");
            System.out.println("Chọn chức năng:");
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    quanLyDanhBa.hienThiDanhBa();
                    break;
                case "2":
                    quanLyDanhBa.themVaoDanhBa("danhBa.csv");
                    break;
                case "3":
                    quanLyDanhBa.capNhap();
                    break;

                case "4":
                    quanLyDanhBa.xoaDanhBa();
                    break;
                case "5":
                    quanLyDanhBa.timKiemDanhBa();
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    System.out.println("Bạn đã thoát...!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Bạn nhập sai vui lòng nhập lại......!");
                    System.exit(0);
                    break;
            }
        } while (choose != "8");
    }
}
