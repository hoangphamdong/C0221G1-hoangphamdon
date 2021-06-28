package com.example.model.service.impl;


import com.example.model.entity.UserRentEntity;
import com.example.model.repository.UserRentRepository;
import com.example.model.service.UserRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class UserRentServiceImpl implements UserRentService {

    @Autowired
    private UserRentRepository userRentRepository;

    @Override
    public List<UserRentEntity> findAll() {
        return userRentRepository.findAll();
    }

    @Override
    public Optional<UserRentEntity> findById(Integer id) {
        return userRentRepository.findById(id);
    }

    @Override
    public void save(UserRentEntity userRentEntity) {
        userRentRepository.save(userRentEntity);
    }

    @Override
    public void delete(Integer id) {
        userRentRepository.deleteById(id);
    }

    @Override
    public UserRentEntity findAllByCode(String code) {
        return userRentRepository.findAllByCode(code);
    }
}