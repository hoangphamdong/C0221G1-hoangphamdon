package b12_java_collection_framework.bai_tap.manager;

import java.util.*;

public class ManagerProduct {
    static List<Product1> list = new ArrayList<>();

    public static void addProduct(Product1 product1) {
        list.add(product1);
    }

//    public static void editProduct(int id, String name, int price) {
//        int sizeEdit = list.size();
//        for (int i = 0; i < sizeEdit; i++) {
//            if (list.get(i).getId() == id) {
//                System.out.println(list.get(i));
//                list.get(i).setName(name);
//                list.get(i).setPrice(price);
//            }
//        }
//    }
public static void editIdProduct(int id) {
    Scanner input=new Scanner(System.in);
    int sizeEdit = list.size();
    for (int i = 0; i < sizeEdit; i++) {
        if (list.get(i).getId() == id) {
            int choice;
            do {
                System.out.println("you edit:\n" +
                                    "1.Edit name\n" +
                                    "2.Edit price\n" +
                                    "3.Edit all\n"+
                                    "0.exit");
                System.out.println("Enter choice");
                choice=Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        input.skip("\\R");
                        System.out.println("input name edit:");
                        String editName=input.nextLine();
                        list.get(i).setName(editName);
                        break;
                    case 2:
                        System.out.println("Input price edit:");
                        int editPrice=Integer.parseInt(input.nextLine());
                        list.get(i).setPrice(editPrice);
                        break;
                    case 3:

                        System.out.println("input name edit:");
                        String editNameAll=input.nextLine();
                        list.get(i).setName(editNameAll);

                        System.out.println("Input price edit:");
                        int editPriceAll=Integer.parseInt(input.nextLine());
                        list.get(i).setPrice(editPriceAll);
                        break;
                    default:
                        System.out.println("nhập sai");

                }
            }while (choice!=0);



        }
    }
}

    public static void deleteProduct(int id) {
        int sizeDelete = list.size();
        int count = 0;
        for (int i = 0; i < sizeDelete; i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                count++;
                for (Product1 d : list) {
                    System.out.println(d.toString());
                }
            }
        }
        if (count == 0) {
            System.out.println("not find id");
        }
        ;
    }

    public static void showProduct() {
        System.out.println("list");
        priceComparator();


    }

    public static void search(String name) {
        int sizeSearch = list.size();
        int count = 0;
        for (int i = 0; i < sizeSearch; i++) {
            if (list.get(i).getName() == name) {
                count++;
                System.out.println(list.get(i));

            }
        }
        if (count == 0) {
            System.out.println("not find");
        }
    }

    public static void priceComparator() {
        Collections.sort(list, new Comparator<Product1>() {
            @Override
            public int compare(Product1 o1, Product1 o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (Product1 t : list) {
            System.out.println(t.toString());
        }
    }
}
