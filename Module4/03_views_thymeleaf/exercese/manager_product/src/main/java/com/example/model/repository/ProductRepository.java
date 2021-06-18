package com.example.model.repository;

import com.example.model.bean.Product;
import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Redbull", 15.000, "abc", "redbull"));
        products.put(2, new Product(2, "Coca", 12.000, "acd", "Coca"));
        products.put(3, new Product(3, "Pepsi", 10.000, "sbc", "Pepsi"));
        products.put(4, new Product(4, "Mirida", 17.000, "zxc", "Mirida"));
        products.put(5, new Product(5, "Monster", 35.000, "fdf", "Nutri Bost"));
        products.put(6, new Product(6, "Nutri Bost", 22.000, "err", "redbull"));
        products.put(7, new Product(7, "Revive", 14.000, "akd", "Coca"));
    }


    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public void save(Product product) {
        products.put(product.getProductId(), product);
    }

    public Product findById(int productId) {
        return products.get(productId);
    }

    public void update(int id, Product product) {
        products.put(id, product);
    }

    public void remove(int id) {
        products.remove(id);
    }

    public List<Product> findByName(String name) {
        List<Product> productList=new ArrayList<>(products.values());
        List<Product>findList=new ArrayList<>();
        for (Product p : productList) {
            if(p.getProductName().contains(name)){
                findList.add(p);
            }
        }
        return findList;

    }


}
