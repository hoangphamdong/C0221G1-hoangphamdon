package com.example.model.repository;

import com.example.model.entity.Customer;
import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Integer> {

    @Query(value = "select * from Customer where `name` like :keywordParam", nativeQuery = true)
    Page<Customer> getCustomerBySearchingName(Pageable pageable, @Param("keywordParam") String keyword);

    @Query(value = "select * from Customer where `name` like :keywordParam and birthday like :birthday",nativeQuery = true)
    Page<Customer>getCustomerBySearchingNameBirthday(Pageable pageable, @Param("keywordParam")String keyword,@Param("birthday")String birthday);

//    @Query(value = "select * from Customer where `name` like :keywordParam",nativeQuery = true)
//    Page<Customer>getCustomerBySearchingNameType(Pageable pageable, @Param("keywordParam")String keyword);
//
//    @Query(value = "select * from Customer where `name` like :keywordParam",nativeQuery = true)
//    Page<Customer>getCustomerBySearchingTypeBirthday(Pageable pageable, @Param("keywordParam")String keyword);
    @Query(value = "SELECT * FROM customer where `name` like :name  and birthday like :birthday and customer_type_id like :type",nativeQuery = true)
    Page<Customer>findCustomerByNameBirthdayAndType(@Param("name") String name,@Param("birthday") String birthday,@Param("type") String type,Pageable pageable);

    Page<Customer>findCustomerByNameContainingAndBirthdayContainingAndCustomerType(String name, String birthday, Integer type, Pageable pageable);
}
