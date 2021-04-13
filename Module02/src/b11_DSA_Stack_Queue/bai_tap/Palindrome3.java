package b11_DSA_Stack_Queue.bai_tap;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome3 {
    public static Stack<String>addStack(String chain){
        Stack<String> stack=new Stack<>();
        for (int i=0;i<chain.length();i++){
            stack.push(String.valueOf(chain.charAt(i)));
        }
        return stack;
    }
    public static Queue<String>addQueue(String chain){
        Queue<String>queue=new LinkedList<>();
        for (int i=0;i<chain.length();i++){
            queue.add(String.valueOf(chain.charAt(i)));
        }
        return queue;
    }

    public static boolean check(Stack<String>stack,Queue<String>queue){
        if(!stack.pop().equals(queue.remove())){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String chain;
        System.out.println("Input chain: ");
        chain=input.nextLine();
        String str=chain.toLowerCase();
        boolean Palindrome=check(addStack(str),addQueue(str));
        if(Palindrome){
            System.out.println("Palindrome");
        }else {
            System.out.println("Is not Palindrome");
        }
    }
}
