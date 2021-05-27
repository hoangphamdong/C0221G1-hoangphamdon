package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class TotalRow {
    public static void main(String[] args) {
        int row;
        int col;

        Scanner input=new Scanner(System.in);
        System.out.println("Enter number of rows");
        row=input.nextInt();
        System.out.println("Enter number of columns");
        col=input.nextInt();
        int[][] array=new int[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print("element ["+i+"]["+j+"]");
                array[i][j]=input.nextInt();
            }
        }System.out.println("Array: ");
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Enter column index");
        int choice=input.nextInt();
        int sum=0;
        for (int i=0;i<row;i++){
            sum+=array[i][choice-1];
        }
        System.out.println("Sum of the column: "+sum);




    }
}
