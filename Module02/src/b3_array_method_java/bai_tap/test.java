package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        int row;
        int column;
        int[] array1;
        int[][] array2;
        System.out.println("input size Array1: ");
        do {
            System.out.println("Enter a size");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);
        array1 = new int[size];
        int i = 0;
        System.out.println("input element array1: ");
        while (i < size) {
            System.out.println("Element" + (i + 1));
            array1[i] = input.nextInt();
            i++;
        }
        System.out.println("Show Array1: ");
        for (int j = 0; j < size; j++) {
            System.out.print(array1[j] + " ");
        }
        System.out.println("\ninput size Array2: ");
        do {
            System.out.println("input of row");
            row = input.nextInt();
            System.out.println("input of column");
            column = input.nextInt();
            if (row > 20 || column > 20) {
                System.out.println("quá 20");
            }
        } while (row > 20 || column > 20);
        array2 = new int[row][column];
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < column; k++) {
                System.out.println("Element [" + j + "][" + k + "]");
                array2[j][k] = input.nextInt();
            }
        }
        System.out.println("Array2: ");
        for (int j=0;j<row;j++){
            for (int k=0;k<column;k++){
                System.out.print(array2[j][k]);
            }
            System.out.println();
        }

    }
}
