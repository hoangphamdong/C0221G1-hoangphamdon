package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class SumCross {
    public static void main(String[] args) {
        int row;
        int column;
        Scanner input =new Scanner(System.in);
        System.out.println("Enter number of rows");
        row=input.nextInt();
        System.out.println("Enter number of columns");
        column=input.nextInt();
        int[][] array=new int[row][column];
        for (int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.println("element ["+i+"]["+j+"]");
                array[i][j]=input.nextInt();
            }
        }for (int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }int sum=0;
        for (int i=0;i<array.length;i++){
            sum+=array[i][i];
        }
        System.out.println("Sum: "+sum);
    }
}
