package b3_array_method_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] array3 = new int[10];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
            index += 1;
        }
        for (int i = index; i < array3.length; i++) {
            array3[i] = array2[i - 5];
        }
        System.out.println("array 3:");
        System.out.println(Arrays.toString(array3));

    }
}
