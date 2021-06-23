package com.example.create_app_blog.model.service;

import java.util.Optional;

public interface IBlogService <T>{
    Iterable<T> findAll();

    Optional findById(int id);

    void save(T model);

    void remove(int id);
}
