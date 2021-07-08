package com.example.model.service.impl;

import com.example.model.entity.CustomerType;
import com.example.model.repository.ICustomerTypeRepository;
import com.example.model.service.ICustomerTypeService;
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
    public Optional<CustomerType> findById(Integer id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(Integer id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public Page<CustomerType> pageAndSearch(Pageable pageable, String keyword) {
        return customerTypeRepository.getCustomerTypeSearchingName(pageable, "%" + keyword + "%");
    }
}
