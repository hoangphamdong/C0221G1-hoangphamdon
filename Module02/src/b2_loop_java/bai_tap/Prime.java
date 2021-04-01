package b2_loop_java.bai_tap;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int numbers;
        int N=2;
        int count=0;
        boolean check=true;
        System.out.println("how many numbers do you want to print");
        numbers=input.nextInt();
       while (count<numbers){
          for (int i=2;i<=Math.sqrt(N);i++){
              if(N%i==0){
                  check=false;
                  break;
              }
          } if(check) {
               System.out.println(N);
               count++;
           }
          check = true;
          N++;
       }


}}
