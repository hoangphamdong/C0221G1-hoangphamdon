package com.example.model.service;

import com.example.model.entity.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer> {
    @Override
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer model);
    void remove(int id);
}
