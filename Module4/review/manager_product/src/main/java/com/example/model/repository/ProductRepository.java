package com.example.model.repository;

import com.example.model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Revive", 12.000, "asd", "Revive"));
        products.put(2, new Product(2, "Redbull", 12.000, "asd", "Revive"));
        products.put(3, new Product(3, "Coca", 12.000, "asd", "Revive"));
        products.put(4, new Product(4, "Pepsi", 12.000, "asd", "Revive"));
    }

    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>(products.values());
        return productList;
    }
}
