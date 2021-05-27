package baiTapLamThem.controllers;

import baiTapLamThem.commons.FileUtils;
import baiTapLamThem.commons.StringUtils;
import baiTapLamThem.models.Oto;
import baiTapLamThem.models.PhuongTienGiaoThong;
import baiTapLamThem.models.XeMay;
import baiTapLamThem.models.XeTai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner input = new Scanner(System.in);
    private static String OTO = "oto";
    private static String XETAI = "xeTai";
    private static String XEMAY = "xeMay";
    private static boolean isBack;

    public static void mainMenu() {
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
                                addNewVehicle();
                                break;
                            case 2:
                                showVehicle();
                                break;
                            case 3:
                                System.out.println("Nhập biển kiểm soat:");
                                String bienKiemXoat=input.nextLine();
                                delete(bienKiemXoat);
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
    private static void delete (String filName){
        FileUtils.readFile();
    }

//    private static void delete(String bienKiemSoat){
//        List<PhuongTienGiaoThong> xeMayList= readAll(XEMAY);
//        List<PhuongTienGiaoThong> xeTaiListList= readAll(XETAI);
//        List<PhuongTienGiaoThong> otoList= readAll(OTO);
//        int countXeMay=0;
////        int countXeTai=0;
////        int countXeOto=0;
//        int indexXeMay=0;
//        for (PhuongTienGiaoThong xeMay: xeMayList) {
//            if (bienKiemSoat.equals(xeMay.getBienKiemSoat())) {
//                countXeMay++;
//                indexXeMay = xeMayList.indexOf(xeMay);
//            }
//        }
//        if (countXeMay == 0) {
//            System.out.println("Khong tim thay!");
//        } else {
//            xeMayList.remove(indexXeMay);
//        }
//    }

    private static void deleteVehicle() {

        int choose = 0;
        while (true) {
            try {
                do {
                    System.out.println("1.\tXóa Xe Tai\n" +
                            "2.\tXóa oto\n" +
                            "3.\tXóa xe máy\n" +
                            "4.\tquay lai menu chính\n" +
                            "5.\tthoat.");
                    System.out.println("nhập lựa chọn của bạn:");
                    choose = Integer.parseInt(input.nextLine());
                    if (choose < 1 || choose > 5) {
                        System.out.println("Vui lòng nhập từ 1--->5");
                    } else {
                        switch (choose) {
                            case 1:

                                isBack = false;
                                break;
                            case 2:

                                break;
                            case 3:
                                showAll(XEMAY);
                            case 4:
                                isBack = true;
                                break;
                            case 5:
                                System.exit(0);
                                break;
                        }


                    }

                } while (choose != 4);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng Nhập số nguyên..!");
            }
            if (isBack) {
                return;
            }
        }

    }
    public static void showAll(String fileName){
        System.out.println("****************************************");
        System.out.println("List:");
        for (PhuongTienGiaoThong phuongTienGiaoThong:readAll(fileName)){
            phuongTienGiaoThong.ShowInfo();
        }
    }
   public static List<PhuongTienGiaoThong>readAll(String fileName ){
        FileUtils.setFullPathFile(fileName);
        List<String>propertiesGTVT=FileUtils.readFile();
        List<PhuongTienGiaoThong> listOfPTGT=new ArrayList<>();
        String[]propertiesElement=null;

        PhuongTienGiaoThong phuongTienGiaoThong=null;

        for (String properties:propertiesGTVT){

            propertiesElement=properties.split(StringUtils.COMMA);
            if(fileName.equals(XETAI)){
                phuongTienGiaoThong=new XeTai();
                ((XeTai)phuongTienGiaoThong).setTrongTai(Integer.parseInt(propertiesElement[4]));
            }else if(fileName.equals(OTO)){
                phuongTienGiaoThong=new Oto();
                ((Oto)phuongTienGiaoThong).setKieuXe(propertiesElement[4]);
                ((Oto)phuongTienGiaoThong).setSoChoNgoi(Integer.parseInt(propertiesElement[5]));
            }else if(fileName.equals(XEMAY)){
                phuongTienGiaoThong=new XeMay();
                ((XeMay)phuongTienGiaoThong).setCongSuat(Integer.parseInt(propertiesElement[4]));
            }

            phuongTienGiaoThong.setBienKiemSoat(propertiesElement[0]);
            phuongTienGiaoThong.setTenHangSanXuat(propertiesElement[1]);
            phuongTienGiaoThong.setNamSanXuat(Integer.parseInt(propertiesElement[2]));
            phuongTienGiaoThong.setChoSoHuu(propertiesElement[3]);
            listOfPTGT.add(phuongTienGiaoThong);
        }return listOfPTGT;

   }


    private static void showVehicle() {
        int choose = 0;
        while (true) {
            try {
                do {
                    System.out.println("1.\tHiển thị xe tải\n" +
                            "2.\tHiển thị oto\n" +
                            "3.\tHiển thị xe máy\n" +
                            "4.\tquay lai menu chính\n" +
                            "5.\tthoat.");
                    System.out.println("nhập lựa chọn của bạn:");
                    choose = Integer.parseInt(input.nextLine());
                    if (choose < 1 || choose > 5) {
                        System.out.println("Vui lòng nhập từ 1--->5");
                    } else {
                        switch (choose) {
                            case 1:
                                showAll(XETAI);
                                isBack = false;
                                break;
                            case 2:
                                showAll(OTO);
                                break;
                            case 3:
                                showAll(XEMAY);
                            case 4:
                                isBack = true;
                                break;
                            case 5:
                                System.exit(0);
                                break;
                        }


                    }

                } while (choose != 4);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng Nhập số nguyên..!");
            }
            if (isBack) {
                return;
            }
        }
    }

    private static void addNewVehicle() {
        int choose = 0;
        while (true) {
            try {
                do {
                    System.out.println("1.\tthem xe tai\n" +
                            "2.\tthem oto\n" +
                            "3.\tthem xe may\n" +
                            "4.\tquay lai menu chinh\n" +
                            "5.\tthoat.");
                    System.out.println("nhập lựa chọn của bạn:");
                    choose = Integer.parseInt(input.nextLine());
                    if (choose < 1 || choose > 5) {
                        System.out.println("Vui lòng nhập từ 1--->5");
                    } else {
                        switch (choose) {
                            case 1:
                                addNewVehicle(XETAI);
                                isBack = false;
                                break;
                            case 2:
                                addNewVehicle(OTO);
                                isBack = false;
                                break;
                            case 3:
                                addNewVehicle(XEMAY);
                                isBack = false;
                                break;
                            case 4:

                                isBack = true;
                                break;
                            case 5:
                                System.exit(0);
                                break;
                        }


                    }

                } while (choose != 4);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng Nhập số nguyên..!");
            }
            if (isBack) {
                return;
            }
        }
    }


    public static void addNewVehicle(String fileName) {
        System.out.println("Nhập biển Kiểm soát:");
        String bienKiemSoat = input.nextLine();

        System.out.println("Nhập Tên hãng Sản Xuất: ");
        String tenHangSanXuat = input.nextLine();

        System.out.println("Nhập Năm Sản Xuất: ");
        int namSanXuat = input.nextInt();

        input.nextLine();
        System.out.println("Nhập Chủ Sở Hữu: ");
        String chuSoHuu = input.nextLine();

        FileUtils.setFullPathFile(fileName);

        if (fileName.equals(XETAI)) {
            System.out.println("Nhập Trọng Tải:");
            int tronTai = input.nextInt();
            FileUtils.writeFile(new String[]{bienKiemSoat, tenHangSanXuat, String.valueOf(namSanXuat), chuSoHuu, String.valueOf(tronTai)});
        } else if (fileName.equals(OTO)) {
            System.out.println("Nhập kiểu xe:");
            String kieuXe = input.nextLine();
            System.out.println("Nhập chổ ngồi");
            String soChoNgoi = input.nextLine();
            FileUtils.writeFile(new String[]{bienKiemSoat, tenHangSanXuat, String.valueOf(namSanXuat), chuSoHuu, kieuXe, soChoNgoi});
        } else if (fileName.equals(XEMAY)) {
            System.out.println("Nhập công suất");
            int congSuat = input.nextInt();
            FileUtils.writeFile(new String[]{bienKiemSoat, tenHangSanXuat, String.valueOf(namSanXuat), chuSoHuu, String.valueOf(congSuat)});
        }
    }


}



