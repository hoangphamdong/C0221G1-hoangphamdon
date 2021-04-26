package b17_binaryFile.bai_tap.managerProduct;

import java.util.*;

public class ManagerProduct {
    static Scanner input = new Scanner(System.in);
    static List<Product> productList = new ArrayList<>();

    public static void addProduct() {
        System.out.print("Nhập Mã Sản Phẩm: ");
        int productCode = Integer.parseInt(input.nextLine());
        System.out.print("Nhập Tên Sản Phẩm: ");
        String productName = input.nextLine();
        System.out.print("Nhập Hãng Sản Xuất: ");
        String producer = input.nextLine();
        System.out.print("Nhập giá: ");
        float price = Float.parseFloat(input.nextLine());
        System.out.print("Nhập Mô Tả khác: ");
        String description = input.nextLine();
        Product product = new Product(productCode, productName, producer, price, description);
        productList.add(product);

        IOFile.writeToFile("src/b17_binaryFile/bai_tap/managerProduct/prodcut.csv", productList);
    }

    public static void search() {
        System.out.print("Nhập Tên Cần Tìm: ");
        String name = input.nextLine();
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().equals(name)) {
                System.out.println(productList.get(i).toString());
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Không Tìm Thấy!");
        }
    }

    public static void showProduct() {
        List<Product>list=IOFile.readDataFromFile("src/b17_binaryFile/bai_tap/managerProduct/prodcut.csv");
        for (Product pr:list){
            System.out.println(pr);
        }
    }

    public static void priceComparator() {
        List<Product>list=IOFile.readDataFromFile("src/b17_binaryFile/bai_tap/managerProduct/prodcut.csv");
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                }else if(o1.getPrice()==o2.getPrice()){
                    return 0;
                }else
                    return -1;
            }
        });
        System.out.println("Sắp xếp tăng dần");
        for (Product pr:list){
            System.out.println(pr.toString());
        }
        IOFile.writeToFile("src/b17_binaryFile/bai_tap/managerProduct/prodcut.csv",list);
    }
}
