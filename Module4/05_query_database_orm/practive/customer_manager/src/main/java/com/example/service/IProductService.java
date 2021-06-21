package com.example.service;

import com.example.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product>findAll();
    void save(Product product);
}
