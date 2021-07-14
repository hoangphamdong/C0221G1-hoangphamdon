package com.example.model.service.impl;

import com.example.model.entity.Customer;
import com.example.model.repository.ICustomerRepository;
import com.example.model.service.ICustomerService;
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
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> pageAndSearch(Pageable pageable, String keyword) {
        return customerRepository.getCustomerBySearchingName(pageable, "%" + keyword + "%");
    }

    @Override
    public Page<Customer> pageAndSearchBirthday( String keyword, String birthday,Pageable pageable) {
        return customerRepository.getCustomerBySearchingNameBirthday(pageable,keyword,birthday);
    }


    @Override
    public Page<Customer> getCustomerByNameBirthdayAndType(String name, String birthday, String type, Pageable pageable) {
        return customerRepository.findCustomerByNameBirthdayAndType("%"+name+"%","%"+birthday+"%","%"+type+"%",pageable);
    }

    @Override
    public Page<Customer> getCustomerByNameBirthdayAndType1(String name, String birthday, Integer type, Pageable pageable) {
        return customerRepository.findCustomerByNameContainingAndBirthdayContainingAndCustomerType(name,birthday,type,pageable);
    }
}
