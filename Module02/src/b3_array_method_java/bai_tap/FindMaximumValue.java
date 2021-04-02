package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class FindMaximumValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row;
        int column;
        int[][] array;
        do {
            System.out.println("Enter a row");
            row = input.nextInt();
            if (row > 20) {
                System.out.println("row should not exceed 20");
            }
        } while (row > 20);
        do {
            System.out.println("Enter column");
            column = input.nextInt();
            if (column > 20) {
                System.out.println("row should not exceed 20");
            }
        } while (column > 20);
        array = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Array" + "[" + i + "]" + "[" + j + "]");
                array[i][j] = input.nextInt();
            }

        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ",");
            }
            System.out.println();
        }
        int maximum = array[0][0];
        int iMax = 0;
        int jMax = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maximum) {
                    maximum = array[i][j];
                    iMax = i;
                    jMax = j;
                }
            }
        }
        System.out.println("maximum " + maximum + " index " + "[" + iMax + "]" + "[" + jMax + "]");
    }
}
