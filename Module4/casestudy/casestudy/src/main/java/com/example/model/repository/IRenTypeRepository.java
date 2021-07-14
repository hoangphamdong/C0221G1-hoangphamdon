package com.example.model.repository;

import com.example.model.entity.RenType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRenTypeRepository extends PagingAndSortingRepository<RenType,Integer> {
}
