package com.example.model.service.impl;

import com.example.model.entity.AppUser;

import com.example.model.repository.IUserRepository;
import com.example.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;


    @Override
    public Iterable<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(AppUser appUser) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<AppUser> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<AppUser> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


    @Override
    public Optional<AppUser> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void remove(String username) {

    }
}
