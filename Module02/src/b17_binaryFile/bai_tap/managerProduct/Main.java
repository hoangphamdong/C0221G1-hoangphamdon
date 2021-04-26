package b17_binaryFile.bai_tap.managerProduct;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int choice;
        try{
            do{
                System.out.println("Menu:\n" +
                        "1.Thêm Sản Phẩm\n" +
                        "2.Hiển Thị Sản Phẩm\n" +
                        "3.Sắp Xếp Sản Phẩm\n" +
                        "4.Tìm Kiếm Sản Phẩm\n"+
                        "0.Thoát.");
                System.out.println("nhập lựa chọn");
                choice= Integer.parseInt(input.nextLine());
                if(choice<0 || choice >4) {
                    System.out.println("Vui lập nhập lựa chọn từ 0 -> 3");
                } else {
                    switch (choice) {
                        case 0:
                            System.out.println("Bạn ĐÃ Thoát...!");
                            break;
                        case 1:
                            ManagerProduct.addProduct();
                            break;
                        case 2:
                            ManagerProduct.showProduct();
                            break;
                        case 3:
                            ManagerProduct.priceComparator();
                            break;
                        case 4:
                            ManagerProduct.search();
                            break;
                    }
                }
            }while (choice>0 || choice <4);
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
