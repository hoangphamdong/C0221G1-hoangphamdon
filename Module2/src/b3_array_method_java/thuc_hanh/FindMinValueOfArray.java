package b3_array_method_java.thuc_hanh;

public class FindMinValueOfArray {
    public static int minValue(int[] array){
        int min=array[0];
        for (int i=0;i<array.length;i++){
            if(array[i]<min) {
                min = array[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + index);
    }
}
