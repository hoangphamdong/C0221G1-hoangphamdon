package com.example.model.service.impl;

import com.example.model.entity.Customer;
import com.example.model.repository.CustomerRepository;
import com.example.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer model) {
        customerRepository.save(model);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
