package com.example.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IService<T> {
    Iterable<T>findAll();
    Optional<T>findById(Integer id);
    void save(T t);
    void remove(Integer id);
    Page<T>pageAndSearch(Pageable pageable,String keyword);
    Page<T>pageAndSearchBirthday(String keyword,String birthday,Pageable pageable);
}
