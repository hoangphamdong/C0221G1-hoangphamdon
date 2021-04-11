package b8_cleanCode.bai_tap;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
    Scanner input =new Scanner(System.in);
    int size;
    int[] array;
    do{
        System.out.println("Enter size");
        size=input.nextInt();
        if(size>20){
            System.out.println("Size does not exceed 20");
        }

    }while (size>20);
    array=new int[size];
    int i=0;
    while (i<array.length){
        System.out.println("Element "+(i+1)+":");
        array[i]=input.nextInt();
        i++;
    }
        System.out.printf("%-20s%s","Element in array","");
        for (int j=0;j<array.length;j++){
            System.out.print(array[j]+"\t");
        }




    }


}


