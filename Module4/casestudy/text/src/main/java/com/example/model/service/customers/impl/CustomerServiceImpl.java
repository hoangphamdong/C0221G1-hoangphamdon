package com.example.model.service.customers.impl;

import com.example.model.entity.customer.Customer;
import com.example.model.repository.customers.ICustomerRepository;
import com.example.model.service.customers.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> pageAndSearch(Pageable pageable, String keyword) {
        return customerRepository.getCustomerBySearchingName(pageable, "%" + keyword + "%");
    }
}
