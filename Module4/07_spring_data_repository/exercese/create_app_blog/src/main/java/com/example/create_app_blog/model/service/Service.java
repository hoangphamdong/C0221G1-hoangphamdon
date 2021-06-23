package com.example.create_app_blog.model.service;

import java.util.Optional;

public interface Service<T> {
    Iterable<T> findAll();

    Optional findById(Long id);

    void save(T model);

    void remove(Long id);
}
