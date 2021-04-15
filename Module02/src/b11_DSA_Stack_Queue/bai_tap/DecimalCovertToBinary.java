package b11_DSA_Stack_Queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class DecimalCovertToBinary {
    public static String bStack(int decimal){
        Stack<Integer>stack=new Stack<>();
        while ((int) decimal / 2 != 0) {
            int decimalHalf = (int) decimal /2 ;
        int binary = (int) decimal % 2;
        stack.push(binary);
        decimal = decimalHalf;
        if ((int) decimal / 2 == 0) {
            stack.push(1);
        }
    }
        String string = "";
        int size = stack.size();
        for (int i=0;i<size;i++){
            string+=stack.pop();
        }return string;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int decimal;
        System.out.println("Enter ");
        decimal=input.nextInt();
        System.out.println(bStack(decimal));
    }

}
