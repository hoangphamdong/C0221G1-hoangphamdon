package com.example.model.service;


import jdk.nashorn.internal.runtime.options.Option;

import java.util.Optional;

public interface Service <T>{
    Iterable<T>finAll();
    Optional<T> findById(Long id);
    void save (T t);
    void remove(Long id);
}
