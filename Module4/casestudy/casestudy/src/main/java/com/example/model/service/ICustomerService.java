package com.example.model.service;

import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IService<Customer> {
    Page<Customer>getCustomerByNameBirthdayAndType(String name,String birthday,String type,Pageable pageable);
    Page<Customer>getCustomerByNameBirthdayAndType1(String name,String birthday,Integer type,Pageable pageable);

}
