package com.example.model.repository;

import com.example.model.entity.UserRentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRentRepository extends JpaRepository<UserRentEntity, Integer> {
    public UserRentEntity findAllByCode(String code);
}