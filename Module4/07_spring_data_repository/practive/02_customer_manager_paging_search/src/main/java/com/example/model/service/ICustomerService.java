package com.example.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService <T>{
    Page<T> findAll(Pageable pageable);
    Optional<T>findById(long id);
    void save(T t);
    void remove(Long id);
    Page<T> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
