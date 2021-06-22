package com.example.store_proceduce.model.service;

import java.util.List;

public interface Service<T>{
    List<T> findAll();
    void create(String lastName,String firstName);
}
