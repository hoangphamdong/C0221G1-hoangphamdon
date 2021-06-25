package com.example.validate.model.servie;

import java.util.Optional;

public interface Service <T>{
    Iterable<T>finAll();
    Optional<T>findById(Long id);
    void save(T t);
    void remove(Long id);
}
