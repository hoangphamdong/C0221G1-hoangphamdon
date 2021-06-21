package com.example.repository.impl;

import com.example.entity.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ProductRepositoryImpl implements IProductRepository {
    @Override
    public List<Product> findAll() {
        TypedQuery<Product>typedQuery=
                BaseRepository.entityManager.createQuery("select p from product p",Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }
}
