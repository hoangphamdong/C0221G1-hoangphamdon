package b11_DSA_Stack_Queue.bai_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean check = true;
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        String chain = null;
        System.out.println("Input chain:");
        chain = input.nextLine();
        for (int i=0;i<chain.length();i++){
           stack.push(chain.charAt(i));
            queue.add(chain.charAt(i));
        }
       for (int i=0;i<chain.length()/2;i++){
           if(stack.pop()!=queue.remove()){
              check = false;
               break;
           }
       }
if (check){
    System.out.println("Palindrome");
}
else{
    System.out.println("not Palindrome");
}
    }
}
