package com.example.model.repository;

import com.example.model.entity.ServiceType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepository extends PagingAndSortingRepository<ServiceType,Integer> {
}
