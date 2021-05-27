package b11_DSA_Stack_Queue.bai_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome2 {
    public static void check(String chair){
        Stack<Character>stack=new Stack<>();
        Queue<Character>queue=new LinkedList<>();
        char stackChar;
        char queueChar;
        int count=0;
        if (chair == "") {
            System.out.println("Is not a palindrome!");
        } else {
                for (int i=0;i<chair.length();i++){
                    stack.push(chair.charAt(i));
                    queue.add(chair.charAt(i));
                }
                for (int i=0;i<chair.length();i++){
                    stackChar = stack.pop();
                    queueChar = queue.remove();
                    boolean sameWord = stackChar == queueChar
                            || stackChar == Character.toLowerCase(queueChar)
                            || stackChar == Character.toUpperCase(queueChar);
                    if(sameWord){
                        count++;
                    }
            }
        }
        if(count==chair.length()){
            System.out.println("Is Palindrome");
        } else {
            System.out.println("Is not a palindrome!");
        }

    }


}
