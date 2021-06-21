package com.example.model.service;

import java.util.List;

public interface Service<T> {
    List<T>findAll();
    T findById(int id);
    void save(T model);
    void remove(int id);
    void update(T model);
}
