package com.example.model.service;


import com.example.model.entity.UserRentEntity;

import java.util.List;
import java.util.Optional;

public interface UserRentService {
    public List<UserRentEntity> findAll();

    public Optional<UserRentEntity> findById(Integer id);

    public void save(UserRentEntity userRentEntity);

    public void  delete(Integer id);

    public UserRentEntity findAllByCode(String code);
}