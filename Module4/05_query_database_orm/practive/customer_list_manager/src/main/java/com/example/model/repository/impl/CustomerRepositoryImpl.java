package com.example.model.repository.impl;

import com.example.model.entity.Customer;
import com.example.model.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        return BaseRepository.entityManager.createQuery("select c " +
                "from customer c", Customer.class).getResultList();
    }

    @Override
    public Customer findById(int id) {
        return BaseRepository.entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer model) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(model);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {

        Customer customer = findById(id);
        if (customer != null) {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            BaseRepository.entityManager.remove(customer);
            entityTransaction.commit();
        }


    }
}
