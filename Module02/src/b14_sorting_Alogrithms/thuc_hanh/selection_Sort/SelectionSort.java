package b14_sorting_Alogrithms.thuc_hanh.selection_Sort;

public class SelectionSort {
    public static void selectionSort(int[] list) {
        int size = list.length;
        for (int i = 0; i < size; i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (list[currentMinIndex] > list[j]) {
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                int temp = list[currentMinIndex];
                list[currentMinIndex] = list[i];
                list[i] = temp;
            }
        }
        System.out.println("list me by sorted and next pass not needed");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
    }


}

