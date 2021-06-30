package com.example.create_app_blog.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Service<T> {
    Page<T>findAll(Pageable pageable);
    Iterable<T> findAll();

    Optional findById(Long id);

    void save(T model);

    void remove(Long id);
    Page<T> findAllByTitleContaining(String name,Pageable pageable);
}
