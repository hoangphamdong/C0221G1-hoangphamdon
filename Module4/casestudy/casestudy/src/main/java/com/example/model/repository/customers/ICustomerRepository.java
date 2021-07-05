package com.example.model.repository.customers;

import com.example.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {

    @Query(value = "select * from customer where customer_name like :keywordParam",nativeQuery = true)
    Page<Customer>getCustomerBySearchingName(Pageable pageable, @Param("keywordParam")String keyword);
}
