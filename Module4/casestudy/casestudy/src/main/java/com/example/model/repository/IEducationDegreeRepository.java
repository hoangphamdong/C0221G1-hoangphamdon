package com.example.model.repository;

import com.example.model.entity.EducationDegree;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends PagingAndSortingRepository<EducationDegree,Integer> {
}
