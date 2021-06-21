package com.example.model.repository.impl;

import com.example.model.entity.Product;
import com.example.model.repository.IProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class ProductRepositoryImpl implements IProductRepository {
    @Override
    public List<Product> findAll() {
        return BaseRepository.entityManager.createQuery("select p from product p", Product.class).getResultList();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void save(Product model) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(model);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            BaseRepository.entityManager.remove(product);
            entityTransaction.commit();
        }
    }

    @Override
    public void update(Product model) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(model);
        entityTransaction.commit();
    }
}
