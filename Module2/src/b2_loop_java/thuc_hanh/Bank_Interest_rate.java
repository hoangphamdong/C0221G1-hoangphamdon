package b2_loop_java.thuc_hanh;

import java.util.Scanner;

public class Bank_Interest_rate {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double money;
        double interest;
        int month;
        System.out.println("Enter investment amount :");
        money=input.nextDouble();
        System.out.println("Enter annual interst rate in percentage: ");
        interest=input.nextDouble();
        System.out.println("Enter number of months :");
        month=input.nextInt();
        double total=0;
        for (int i=0;i<month;i++){
            total+=money*(interest/100)/12*month;
        }
        System.out.printf("Money: %f \n Interest: %f \n Month: %d \n Total: %f",money,interest,month,total);
    }
}
