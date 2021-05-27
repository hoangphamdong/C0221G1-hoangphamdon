package b12_java_collection_framework.bai_tap.product;

import java.util.Scanner;

public class List {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        boolean check=true;
        while (check){
            System.out.println("Select function:\n" +
                    "1.Add\n" +
                    "2.Delete\n" +
                    "3.Search\n" +
                    "4.Show\n" +
                    "0.Exit");
            System.out.println("Enter your choice");
           int choice=input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter your Id");
                    int addId=input.nextInt();
                    System.out.println("Enter your Name");
                    input.nextLine();
                    String addName=input.nextLine();
                    System.out.println("Enter price");
                    double addPrice=input.nextDouble();
                    Product product=new Product(addName,addId,addPrice);
                    ProductManager.add(product);
                    break;
                case 2:
                    ProductManager.show();
                    System.out.println("Enter id delete");
                    int id=input.nextInt();
                    ProductManager.delete(id);
                    break;
                case 3:
                    System.out.println("Enter name search");
                    String nameSearch=input.nextLine();
                    ProductManager.search(nameSearch);
                    break;

                case 4:
                    System.out.println("list");
                    ProductManager.show();
                    break;
                case 0:
                    check=false;
                    System.out.println("kết thúc");
                    break;


            }
        }

    }
}
