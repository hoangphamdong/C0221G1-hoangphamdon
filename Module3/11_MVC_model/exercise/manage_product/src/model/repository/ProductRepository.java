package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private static Map<Integer, Product>products;

    static {
        products=new HashMap<>();
        products.put(1,new Product(1,"Redbull",25.000,"Nước tăng lực","redbull"));
        products.put(2,new Product(2,"Cocacola",12.000,"Nước giải khát","cocacola"));
        products.put(3,new Product(3,"Pepsi",15.000,"Nước giải khat","pepsi"));
        products.put(4,new Product(4,"Mirida",25.000,"Nước tăng lực","Pepse"));
        products.put(5,new Product(5,"Twister",25.000,"Nước tăng lực","cocola"));
        products.put(6,new Product(6,"Tea",25.000,"Nước tăng lực","Phuc Long"));
        products.put(7,new Product(7,"Cofe",25.000,"Nước tăng lực","Trung Nguyen"));
    }
    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }
   public void save(Product product){
        products.put(product.getId(),product);
    }
    public Product findById(int id){
        return products.get(id);
    }
    public void update(int id,Product product){
        products.put(id,product);
    }
    public void remote(int id){
        products.remove(id);
    }

}
