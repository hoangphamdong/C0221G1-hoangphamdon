package com.example.store_proceduce.model.repository;

import com.example.store_proceduce.model.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Query
            (value = "select c from Customer c", nativeQuery = false)
        List<Customer> findAll();
    @Query
            (value =" call Insert_Customer(?,?)", nativeQuery = true)
    void create(String lastName,String firstName);

}
