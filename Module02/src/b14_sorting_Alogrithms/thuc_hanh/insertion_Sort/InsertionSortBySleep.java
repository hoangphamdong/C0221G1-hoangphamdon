package b14_sorting_Alogrithms.thuc_hanh.insertion_Sort;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class InsertionSortBySleep {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int []list;
        int size;
        int i;
        int j;
        System.out.println("Enter list size");
        size=input.nextInt();
        list=new int[size];
        System.out.println("Enter "+list.length+" value");
        for(i=0;i<size;i++){
            System.out.println("input element ["+(i+1)+"]");
            list[i]=input.nextInt();
        }
        for(j=0;j<size;j++){
            System.out.print(list[j]);
        }
        System.out.println("after");
        InsertionSort.insertionSort(list);
    }

}
