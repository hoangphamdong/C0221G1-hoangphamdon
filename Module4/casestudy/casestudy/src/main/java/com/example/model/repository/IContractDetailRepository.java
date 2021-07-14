package com.example.model.repository;

import com.example.model.entity.ContractDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends PagingAndSortingRepository<ContractDetail,Integer> {
}
