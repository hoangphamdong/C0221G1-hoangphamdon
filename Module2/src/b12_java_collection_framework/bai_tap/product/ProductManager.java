package b12_java_collection_framework.bai_tap.product;

import b12_java_collection_framework.bai_tap.product.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    static List<Product>productList=new ArrayList<>();
    public static void add(Product product){
        productList.add(product);
    }
    public static void edit(int id ,String name,double price){
        int size=productList.size();
        for (int i=0;i<size;i++){
         if (productList.get(i).getId()==id){
             productList.get(i).setName(name);
             productList.get(i).setPrice(price);
         }
        }


    }
    public static void delete(int id){
        int size=productList.size();
        int count=0;
        for(int i=0;i<size;i++){
            if(productList.get(i).getId()==id){
                productList.remove(i);
                count++;
            }
        }if(count==0){
            System.out.println("not Find");
        }

    }
    public static void search(String name){
        int size=productList.size();
        for (int i=0;i<size;i++){
            if(productList.get(i).getName()==name){
                System.out.println(productList.get(i).toString());
            }
        }
    }
    public static void priceComparator (){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice()>o2.getPrice()){
                    return 1;
                }else if(o1.getPrice()==o2.getPrice()){
                    return 0;
                }else{
                    return -1;
                }
            }
        });

        for (Product  t:productList) {
            System.out.println(t.toString());
        }
    }
public static void show(){
    for (Product d:productList) {
        System.out.println(d.toString());
    }
}

}