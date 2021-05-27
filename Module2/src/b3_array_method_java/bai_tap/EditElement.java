package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class EditElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5,6};
        System.out.println("Input edit number:");
        int N = input.nextInt();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == N) {
                index=i;
                System.out.println("Position of the array in " + N + " is " + index);
                break;
            }
        }for (int i=index;i<array.length-1;i++){
            array[i]=array[i+1];

        }
        array[array.length-1]=0;

        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
    }

}
