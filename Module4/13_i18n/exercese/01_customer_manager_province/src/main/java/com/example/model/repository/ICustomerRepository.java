package com.example.model.repository;

import com.example.model.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

@org.springframework.stereotype.Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
