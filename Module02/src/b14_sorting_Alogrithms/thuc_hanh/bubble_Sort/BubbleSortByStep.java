package b14_sorting_Alogrithms.thuc_hanh.bubble_Sort;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter list size:");
        int size = input.nextInt();
        int[]list=new int[size];
        System.out.println("Enter "+list.length+"values:");
        for(int i=0;i<list.length;i++){
            list[i]=input.nextInt();
        }
        System.out.println("your input list: ");
    }
}
