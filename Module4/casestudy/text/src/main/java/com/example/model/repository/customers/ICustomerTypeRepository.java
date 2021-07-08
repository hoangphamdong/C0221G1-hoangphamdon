package com.example.model.repository.customers;

import com.example.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType,Long> {
    @Query(value = "select * from cusomer_type where customer_type_name like :keywordParam",nativeQuery = true)
    Page<CustomerType>getCustomerTypeSearchingName(Pageable pageable, @Param("keywordParam") String keyword);
}
