package com.example.model.service.impl;

import com.example.model.bean.Customer;
import com.example.model.repository.CustomerRepository;
import com.example.model.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
