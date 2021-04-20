package b14_sorting_Alogrithms.thuc_hanh.bubble_Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int []list){
        boolean needNextPass = true;
        for(int i=1;i<list.length&&needNextPass;i++){
            needNextPass=false;
            for(int j=0;j<list.length-i;j++){
                if(list[j]>list[j+1]){
                    int temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                    needNextPass=true;
                }
            }
        }

    }

}
