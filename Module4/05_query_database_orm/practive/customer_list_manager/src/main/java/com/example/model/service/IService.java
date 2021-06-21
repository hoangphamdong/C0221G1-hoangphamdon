package com.example.model.service;

import com.example.model.entity.Customer;

import java.util.List;

public interface IService <T> {
    List<T>findAll();
    T findById(int id);
    void save(T model);
    void remove(int id);
}
