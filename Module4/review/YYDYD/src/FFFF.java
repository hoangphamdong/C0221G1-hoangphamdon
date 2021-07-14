import java.sql.Array;
import java.util.Collections;

public class FFFF {
    public static int findSecondMaxNumber(int[] arr) {
        int a;
        int b;
        if (arr[0] > arr[1]) {
            a = arr[0];
            b = arr[1];
        } else {
            a = arr[1];
            b = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            if (a < arr[i]) {
                b = a;
                a = arr[i];

            } else if (b < arr[i]) {
                b = arr[i];
            }
        }
        return b;
    }

    public static void main(String[] args) {
    int arr[]={1,2,4,4,5,3};
        System.out.println(findSecondMaxNumber(arr));
    }
}
