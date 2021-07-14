package com.example.model.service.impl;

import com.example.model.entity.RenType;
import com.example.model.repository.IRenTypeRepository;
import com.example.model.service.IRenTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RenTypeServiceImpl implements IRenTypeService {
    @Autowired
    private IRenTypeRepository renTypeRepository;
    @Override
    public Iterable<RenType> findAll() {
        return renTypeRepository.findAll();
    }

    @Override
    public Optional<RenType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(RenType renType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<RenType> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<RenType> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
