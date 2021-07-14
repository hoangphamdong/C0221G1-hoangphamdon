package com.example.model.repository;

import com.example.model.entity.AppUser;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<AppUser,String> {
}
