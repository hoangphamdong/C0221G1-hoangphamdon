package b11_DSA_Stack_Queue.bai_tap;

import jdk.nashorn.internal.parser.Scanner;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<Integer>();
        Stack<Integer>reverse=new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        int size=stack.size();
        for (int i=0;i<size;i++){
            reverse.push(stack.pop());
        }

    }


}


