package com.example.repository;

import com.example.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product>findAll();
    void save (Product product);
}
