package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class FindTheSmallestValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter a size: ");
            size = input.nextInt();
            if (size > 20) {
                System.out.print("size should not exceed 20");
            }
        } while (size > 20);
        int i = 0;
        int[] array = new int[size];
        while (i < array.length) {
            System.out.println("Enter element " + (i + 1));
            array[i] = input.nextInt();
            i++;
        }
        System.out.print("Array: ");
        for (int j = 0; j < array.length; j++) {

            System.out.print(array[j] + "\t");
        }
        int min = array[0];
        int index = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                index = j;
            }
        }
        System.out.print("Value min: " + min + " index: " + index);
    }
}
