package com.example.model.repository;

import com.example.model.entity.AttachService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepository extends PagingAndSortingRepository<AttachService,Integer> {
}
