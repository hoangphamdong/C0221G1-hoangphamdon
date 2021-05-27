package b12_java_collection_framework.bai_tap.manager;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int choice;
        do{
            System.out.println("Choice function:\n" +
                                "1.Add Product\n" +
                                "2.Show Product\n" +
                                "3.Delete Product\n" +
                                "4.Edit\n" +
                                "0.Exit");
            System.out.println("Enter your choice");
            choice=input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter add id");
                    int addId=input.nextInt();
                    input.nextLine();
                    System.out.println("Enter add name");
                    String addName=input.nextLine();

                    System.out.println("Enter add price");
                    double addPrice=input.nextDouble();
                    Product1 product1=new Product1(addId,addName, (int) addPrice);
                    ManagerProduct.addProduct(product1);
                    break;
                case 2:
                    ManagerProduct.showProduct();
                    break;
                case 3:
                    ManagerProduct.showProduct();
                    System.out.println("Enter id delete");
                    int deleteId=input.nextInt();
                    ManagerProduct.deleteProduct(deleteId);
                    System.out.println("sau khi xóa");
                    ManagerProduct.showProduct();
                case 4:
                    ManagerProduct.showProduct();
                    System.out.println("enter id need edit");
                    int idEdit=input.nextInt();
                    ManagerProduct.editIdProduct(idEdit);
                    break;
            }
        }while (choice!=0);

    }
}
