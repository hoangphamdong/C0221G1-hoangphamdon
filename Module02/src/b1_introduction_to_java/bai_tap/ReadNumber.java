package b1_introduction_to_java.bai_tap;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String num;
            System.out.println("Enter number need read: ");
            num=scanner.nextLine();
            switch (num){
                case "0":
                    System.out.println("zero");
                    break;
                case "1":
                    System.out.print("one");
                    break;
                case "2":
                    System.out.println("two");
                    break;
                case "3":
                    System.out.println("three");
                    break;
                case "4":
                    System.out.println("four");
                    break;
                case "5":
                    System.out.println("five");
                    break;
                case "6":
                    System.out.println("six");
                    break;
                case "7":
                    System.out.println("seven");
                    break;
                case "8":
                    System.out.println("eight");
                    break;
                case "9":
                    System.out.println("nine");
                    break;
                case "10":
                    System.out.println("ten");
                    break;
                case "11":
                    System.out.println("eleven");
                    break;
                case "12":
                    System.out.println("twelve");
                    break;
                case "20":
                    System.out.print("twenty");
                    break;
                case "30":
                    System.out.println("Thirty");
                    break;
                case "40":
                    System.out.println("forty");
                    break;
                case "50":
                    System.out.println("fifty");
                    break;
                case "60":
                    System.out.println("sixty");
                    break;
                case "70":
                    System.out.println("seventy");
                    break;
                case "80":
                    System.out.println("eighty");
                    break;
                case "90":
                    System.out.println("ninety");
                    break;
                case "100":
                    System.out.println("hundred");
                    break;

        }


    }
}
