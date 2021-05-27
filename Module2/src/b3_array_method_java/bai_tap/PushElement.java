package b3_array_method_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class PushElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;
        int[] array=new int[10];

        for (int i=0;i<array.length;i++){
            System.out.println("Enter element"+(i+1));
            array[i]=scanner.nextInt();
        }
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("Enter index need push");
        int index=scanner.nextInt();
        System.out.println("Enter number need push");
        N=scanner.nextInt();
        int[] arrayNew=new int[array.length+1];
        for (int i=0;i<index;i++){
            arrayNew[i]=array[i];
        }
        arrayNew[index]=N;
        for (int i=index+1;i<arrayNew.length;i++){
            arrayNew[i]=array[i-1];
        }
        System.out.println(Arrays.toString(arrayNew));

    }
}
