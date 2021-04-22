package b15_exceptionAndDebug.thuc_hanh.arrayException;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestArray {
    public static void main(String[] args) {
        int []arr=ArrayExample.createRandom();
        Scanner input=new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int x=input.nextInt();
        try{
            System.out.println("Giá trị của phần tử có chỉ số "+x+" là "+arr[x]);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Chỉ số vượt quá giới hạn của mảng");
        }

    }
}
