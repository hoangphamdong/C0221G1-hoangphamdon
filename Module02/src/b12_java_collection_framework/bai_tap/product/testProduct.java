package b12_java_collection_framework.bai_tap.product;

import b12_java_collection_framework.bai_tap.product.Product;
import b12_java_collection_framework.bai_tap.product.ProductManager;

public class testProduct {
    public static void main(String[] args) {
        ProductManager productManager=new ProductManager();
        Product product1=new Product("dienThoai",123,1500);
        Product product2=new Product("mayTinh",124,20000);
        Product product3=new Product("mayTinh",124,1000);
      productManager.add(product1);
      productManager.add(product2);
      productManager.add(product3);

      productManager.show();
      productManager.edit(123,"laptop",25000);
      ProductManager.delete(125);





    }
}
