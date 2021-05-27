package b3_array_method_java.thuc_hanh;

import java.util.Scanner;

public class PropertyValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.println("Enter size");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Enter element " + (i + 1) + ":");
            array[i] = input.nextInt();
            i++;
        }
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++)
            System.out.print(array[j] + "\t");
        int max = array[0];
        int index = 1;
        for (int k = 0; k < array.length; k++) {
            if (array[k] > max) {
                max = array[k];
                index = k + 1;
            }
        }
        System.out.println("The largest property value in the list is "+max+" ,at position "+index);
    }


}
