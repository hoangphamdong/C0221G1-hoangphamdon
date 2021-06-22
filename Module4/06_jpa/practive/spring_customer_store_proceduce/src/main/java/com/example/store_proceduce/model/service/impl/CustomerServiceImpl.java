package com.example.store_proceduce.model.service.impl;


import com.example.store_proceduce.model.entity.Customer;
import com.example.store_proceduce.model.repository.ICustomerRepository;
import com.example.store_proceduce.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(String lastName, String firstName) {
        customerRepository.create(lastName,firstName);
    }
}
