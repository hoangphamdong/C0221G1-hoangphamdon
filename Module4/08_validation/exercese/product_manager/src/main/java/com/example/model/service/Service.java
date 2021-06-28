package com.example.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Service<T> {
    Iterable<T>findByAll();
    Optional<T>findById(Long id);
    void save(T t);
    void remove(Long id);
    Page<T>getProductBySearchingName(Pageable pageable,String keyword);
}
