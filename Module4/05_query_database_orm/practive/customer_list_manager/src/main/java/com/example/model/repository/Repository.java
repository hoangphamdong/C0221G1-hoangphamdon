package com.example.model.repository;

import com.example.model.entity.Customer;

import java.util.List;

public interface Repository <T> {
    List<T> findAll();
    T findById(int id);
    void save (T model);
    void remove(int id);
}
