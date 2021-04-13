package b11_DSA_Stack_Queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static boolean bStack(String sym){
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<sym.length();i++){
            if('('==sym.charAt(i)){
                stack.push(sym.charAt(i));
            }else if (')'==sym.charAt(i)){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String sym;
        Scanner input=new Scanner(System.in);
        sym=input.nextLine();
        if (bStack(sym)){
            System.out.println("hop le");
        }else {
            System.out.println("khoong hop le");
        }
    }

}
