package b15_exceptionAndDebug.thuc_hanh.arrayException;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public static int[] createRandom(){
        int[] array=new int[100];
        Random random=new Random();
        System.out.println("Danh sách phần tử của mảng");
        for(int i=0;i<100;i++){
            array[i]=random.nextInt(100);
            System.out.print(array[i]+" ");
        }
        return array;
    }
}
