package b14_sorting_Alogrithms.thuc_hanh.selection_Sort;

import java.util.Scanner;

public class SelectionSortBySleep {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int []listSelection;
        int size;
        System.out.println("Enter list size");
        size=input.nextInt();
        listSelection=new int[size];
        System.out.println("Enter "+listSelection.length+" value:");
        for (int i=0;i<size;i++){
            System.out.println("Enter element ["+(i+1)+"]");
            listSelection[i]=input.nextInt();
        }
        System.out.print("list selection [");
        for (int i=0;i<size;i++){
            System.out.print(listSelection[i]+" ");
        }
        System.out.print("]");
        SelectionSort.selectionSort(listSelection);

    }
}
