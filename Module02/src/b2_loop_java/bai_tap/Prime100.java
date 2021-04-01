package b2_loop_java.bai_tap;

import java.util.Scanner;

public class Prime100 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers;
        int N = 2;
        boolean check = true;
        System.out.println("Enter number");
        numbers = input.nextInt();
        while (N < numbers) {
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(N);
            }
            check = true;
            N++;
        }
    }
}
