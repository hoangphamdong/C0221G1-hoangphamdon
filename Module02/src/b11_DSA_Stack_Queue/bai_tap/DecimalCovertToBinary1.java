package b11_DSA_Stack_Queue.bai_tap;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;
import java.util.Stack;

public class DecimalCovertToBinary1 {
    public static String bStack(int decimal){
        Stack<Integer>stack= new Stack<>();
         int num=0;
         String string="";
        while(true){
            boolean decimalHaft = decimal != 0;
            if (!decimalHaft) break;
            num=decimal%2;
           decimal=decimal/2;
           stack.push(num);
        }
        while(!stack.isEmpty()){
            string+=stack.pop();
        }return string;
    }

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int decimal;
        System.out.println("Enter Decimal ");
        decimal=input.nextInt();
        System.out.println("Decimal convert:");
        System.out.println(bStack(decimal));
    }

}
