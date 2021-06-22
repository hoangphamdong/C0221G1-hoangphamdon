package com.example.manager_customer.model.service;

import java.util.Optional;

public interface ICustomerService <T>{
    Iterable<T> findAll();
    Optional<T>findById(long id);
    void save(T t);
    void remove(Long id);
}
