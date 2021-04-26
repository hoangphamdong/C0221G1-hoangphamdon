package bai_lam_them.display;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        while (true){
            Scanner input=new Scanner(System.in);
            try{
                System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG \n" +
                                        "Chọn chức năng:\n" +
                                        "1.Thêm mới phương tiện\n" +
                                        "2.Hiển thị phương tiện\n" +
                                        "3.Xóa phương tiện\n" +
                                        "4.Thoát");
                System.out.println("Chọn chức năng:");
                try{
                    int choice=input.nextInt();
                    MethodChoiceException.choiceMenu(choice);
                }catch (IllegalChoiceException e){
                    System.out.println(e.getMessage());
                }

            }catch (InputMismatchException e){
                System.out.println("Nhập số nguyên");
            }
        }
    }

}
