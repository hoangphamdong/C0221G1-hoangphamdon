package com.example.model.service.impl;

import com.example.model.bean.Product;
import com.example.model.repository.ProductRepository;
import com.example.model.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    ProductRepository productRepository =new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
