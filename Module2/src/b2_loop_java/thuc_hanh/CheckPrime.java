package b2_loop_java.thuc_hanh;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num=scanner.nextInt();
        if (num<2){
            System.out.println(num +" is not Prime");
        }else{
            int i=2;
            boolean check=true;
            while (i<=Math.sqrt(num)){
                if(num%i==0){
                    check=false;
                    break;
                }
                i++;
            }
            if(check){
                System.out.println(num+" is a Prime ");
            }else {
                System.out.println(num+" is not Prime");
            }
        }

    }
}
