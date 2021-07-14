package com.example.model.repository;

import com.example.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends PagingAndSortingRepository<Contract,Integer> {
    @Query(value = "select * from Contract where contract_deposit like :keywordParam",nativeQuery = true)
    Page<Contract>getContractBySearching(Pageable pageable, @Param("keywordParam")String keyword);
}
