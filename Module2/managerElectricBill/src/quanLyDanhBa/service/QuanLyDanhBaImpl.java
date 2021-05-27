package quanLyDanhBa.service;

import hhhh.common.StringUint;
import hhhh.servlice.ServiceCustomerImpl;
import model.Customer;
import quanLyDanhBa.comom.IoFile;
import quanLyDanhBa.comom.Validator;
import quanLyDanhBa.model.DanhBa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyDanhBaImpl implements QuanLyDanhBa {
    private static Scanner input = new Scanner(System.in);

    @Override
    public void themVaoDanhBa(String fileName) {
        List<DanhBa> danhBaList = new ArrayList<>();

        String sodienThoai = null;
        do {
            System.out.println("Nhập số điện thoai:");
            sodienThoai = input.nextLine();
        } while (!Validator.isValidRegex(sodienThoai, Validator.SDT_REGEX));

        System.out.println("Nhập nhóm của danh bạ:");
        String nhomCuaDanhBa = input.nextLine();

        System.out.println("Nhập họ và tên:");
        String hoTen = input.nextLine();

        System.out.println("Nhập giới tính:");
        String gioiTinh = input.nextLine();

        System.out.println("Nhập địa chỉ");
        String diaChi = input.nextLine();

        System.out.println("Nhập ngày sinh:");
        String ngaySinh = input.nextLine();

        String email = null;


        System.out.println("Nhập email:");
        email = input.nextLine();


        DanhBa danhBa = new DanhBa(sodienThoai, nhomCuaDanhBa, hoTen, gioiTinh, diaChi, ngaySinh, email);
        danhBaList.add(danhBa);
        IoFile.writeFile(fileName, danhBaList, true);
    }

    @Override
    public void hienThiDanhBa() {
        System.out.println("Danh Bạ:");
        List<DanhBa> list = IoFile.readFile("danhBa.csv");
        for (DanhBa line : list) {
            line.showInfo();
        }
        System.out.println("---------------------------------");
    }

    @Override
    public void xoaDanhBa() {

        System.out.println("Nhập số điện thoại cần xóa:");
        String soDienThoai = input.nextLine();
        boolean idNotFound = true;
        List<DanhBa> danhBaList = IoFile.readFile("danhBa.csv");
        for (int i = 0; i < danhBaList.size(); i++) {
            if (soDienThoai.equals(danhBaList.get(i).getSoDienThoai())) {
                danhBaList.remove(danhBaList.get(i));
                idNotFound = false;
                break;
            }
        }
        if (idNotFound) {
            System.out.println("không tìm thấy");
        }


    }

    @Override
    public void timKiemDanhBa() {

        String choose = null;
        do {
            System.out.println(" Tìm kiếm danh bạ\n" +
                    "1. Tìm kiếm bằng tên.\n" +
                    "2. Tìm kiếm bằng số điện thoại.\n" +
                    "3. Quay lại menu chính.\n" +
                    "4. Thoát.");
            System.out.println("Vui lòng nhập lựa chọn của bạn");
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Nhập tên cần tìm:");
                    String name = input.nextLine();
                    boolean flag = false;
                    List<DanhBa> danhBaList = IoFile.readFile("danhBa.csv");
                    for (
                            int i = 0; i < danhBaList.size(); i++) {
                        if (danhBaList.get(i).getHoVaTen().equals(name)) {
                            System.out.println("Thông tin khách hàng");
                            System.out.println(danhBaList.get(i).toString());
                            System.out.println("---------------------------------------");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("không tìm thấy");
                    }

                    break;
                case "2":
                    System.out.println("Nhập số điện thoại cần tìm cần tìm:");
                    String soDienThoai = input.nextLine();
                    boolean flag2 = false;
                    List<DanhBa> danhBaList2 = IoFile.readFile("danhBa.csv");
                    for (
                            int i = 0; i < danhBaList2.size(); i++) {
                        if (danhBaList2.get(i).getSoDienThoai().equals(soDienThoai)) {
                            System.out.println("Thông tin khách hàng");
                            System.out.println(danhBaList2.get(i).toString());
                            System.out.println("---------------------------------------");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag2) {
                        System.out.println("không tìm thấy");
                    }

                case "3":
                    return;
                case "4":
                    System.out.println("Bạn đã thoát...!");
                    System.exit(0);
                default:
                    System.out.println("Bạn nhập sai vui lòng nhập lại.");
            }
        } while (choose != "4");
    }

    @Override
    public void capNhap() {
        System.out.println("nhập số điện thoại cần sửa:");
        String soDienThoai = input.nextLine();

        boolean flag = false;
        List<DanhBa> danhBaList2 = IoFile.readFile("danhBa.csv");

        for (int i = 0; i < danhBaList2.size(); i++) {
            if (danhBaList2.get(i).getSoDienThoai().equals(soDienThoai)) {
                String choose = null;
                do {
                    System.out.println(" CẬP NHẬP THÔNG TIN DANH BẠ\n" +
                            "Chọn cập nhập thông tin:\n" +
                            "1. nhóm của danh sách.\n" +
                            "2. họ tên\n" +
                            "3. giới tính\n" +
                            "4. địa chỉ\n" +
                            "5. ngày sinh\n" +
                            "6. email\n" +
                            "7. quay lại menu\n" +
                            "8. Thoát\n");
                    System.out.println("Chọn chức năng:");
                    choose = input.nextLine();
                    switch (choose) {
                        case "1":

                            break;
                        case "2":

                            break;
                        case "3":

                            break;

                        case "4":

                            break;
                        case "5":

                            break;
                        case "6":
                            break;
                        case "7":
                            return;
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
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("không tìm thấy");
        }

    }

    @Override
    public void ghiFile() {

    }


}



