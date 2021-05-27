package b11_DSA_Stack_Queue.bai_tap;

import java.util.Scanner;

public class TestPalindrome {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String chair;
        System.out.println("Enter chair");
        chair=input.nextLine();
        Palindrome2.check(chair);

    }
}
