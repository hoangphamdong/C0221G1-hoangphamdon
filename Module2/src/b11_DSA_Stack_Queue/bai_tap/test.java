package b11_DSA_Stack_Queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Stack<Integer>stack=new Stack<>();
        System.out.println("enter number size");
        int size=scanner.nextInt();
        for (int i=0;i<size;i++){
            System.out.println("");
            stack.push(scanner.nextInt());
        }

        System.out.println(stack);
    }

}
