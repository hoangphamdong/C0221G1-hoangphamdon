package b14_sorting_Alogrithms.thuc_hanh.bubble_Sort;

import java.util.Scanner;

public class BubbleSortBySleep {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int size;
        int[]list;
        System.out.println("Enter list size");
        size=input.nextInt();
        list=new int[size];
        System.out.println("Enter "+list.length+ " values:");
        for (int i=0;i<list.length;i++){
            System.out.println("element ["+(i+1)+"]");
            list[i]=input.nextInt();
        }
        System.out.print("list[");
        for (int i=0;i<list.length;i++){
            System.out.print(list[i]+"\t");
        }
        System.out.println("]");
        System.out.println("\nBegin sort processing...");
        BubbleSort.bubbleSort(list);
    }
}
