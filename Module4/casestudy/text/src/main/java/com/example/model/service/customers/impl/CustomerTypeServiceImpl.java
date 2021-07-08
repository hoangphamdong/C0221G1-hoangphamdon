package com.example.model.service.customers.impl;

import com.example.model.entity.customer.CustomerType;
import com.example.model.repository.customers.ICustomerTypeRepository;
import com.example.model.service.customers.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(Long id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(Long id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public Page<CustomerType> pageAndSearch(Pageable pageable, String keyword) {
        return customerTypeRepository.getCustomerTypeSearchingName(pageable, "%" + keyword + "%");
    }
}
