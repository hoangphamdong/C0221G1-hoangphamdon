package b14_sorting_Alogrithms.thuc_hanh.bubble_Sort;

public class BubbleSort {
    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        for (int i = 1; i < list.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    needNextPass = true;
                }
            }

            if (needNextPass == false) {
                System.out.println("list me by sorted and next pass not needed");
                break;

            }
            System.out.println("List after the "+i+"'sort: ");
            for (int j=0;j<list.length;j++){
                System.out.print(list[j]+"\t");
            }
            System.out.println();
        }
    }
}
