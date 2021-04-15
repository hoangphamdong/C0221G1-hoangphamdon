package b11_DSA_Stack_Queue.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class BinaryCovertToDecimal {
   public static String covertDecimalToBinary(int decimal){
       int temp=0;
       String string ="";
       int decimalHalf=0;
       Stack<Integer>bStack=new Stack<>();
       while(decimal!=0){
          temp= decimal%2;
           decimal=decimal/2;
           bStack.push(temp);
       }while(!bStack.isEmpty()){
           string+=bStack.pop();
       }return string;
   }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int decimal;
        System.out.println("Enter Decimal");
        decimal=input.nextInt();
        System.out.println(covertDecimalToBinary(decimal));
    }
}
