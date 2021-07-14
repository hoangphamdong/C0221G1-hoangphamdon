package com.example.model.repository;

import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
    @Query(value = "select * from Employee where `name` like :keywordParam",nativeQuery = true)
    Page<Employee>getEmployeeBySearchingName(Pageable pageable, @Param("keywordParam") String keyword);

}
