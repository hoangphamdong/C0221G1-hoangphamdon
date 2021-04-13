package b11_DSA_Stack_Queue.bai_tap;

import java.util.Stack;

public class ReverseChair {
    public static void main(String[] args) {
        Stack<String> wStack=new Stack<>();
        String word="hello dong";
        String[]words=word.split("\\s");

        for(String o:words){
            wStack.push(o);
        }
        System.out.println(wStack);
        Stack<String>mStack=new Stack<>();
        int size=wStack.size();
        for (int i=0;i<size;i++){
            mStack.push(wStack.pop());
        }
        System.out.println(mStack);
    }

}
