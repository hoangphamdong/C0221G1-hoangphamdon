package b14_sorting_Alogrithms.thuc_hanh.insertion_Sort;

public class InsertionSort {
    public static void insertionSort(int[]list){
        int x,post,i;
        for (i=1;i<list.length;i++){
            x=list[i];
            post=i;
            while(post>0&&x<list[post-1]){
                int temp=list[post];
                list[post]=list[post-1];
                list[post-1]=temp;
                post--;
            }list[post]=x;
        }
        for (i=0;i<list.length;i++){
            System.out.print(list[i]);
        }
    }
}
