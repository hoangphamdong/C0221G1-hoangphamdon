package b13_searching.thuc_hanh;

public class binarySearch {
    static int[] list = {2, 4, 7, 10, 45, 50, 69};

    static int binarySearch(int[] list, int key) {
        int left = 0;
        int right = list.length - 1;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (key < list[mid]) {
                right = mid - 1;
            }else if (key==list[mid]){
                return mid;
            }else {
                left=mid+1;
            }
        }return -1;
    }

    public static void main(String[] args) {
       int result=binarySearch(list,70);
       if(result!=-1){
           System.out.println("index "+ result);
       }else {
           System.out.println("không tìm thấy");
       }
    }
}
