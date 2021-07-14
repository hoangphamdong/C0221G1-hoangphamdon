package com.example.model.service.impl;

import com.example.model.entity.Division;
import com.example.model.repository.IDivisionRepository;
import com.example.model.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional<Division> findById(Integer id) {
        return divisionRepository.findById(id).empty();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void remove(Integer id) {
        divisionRepository.deleteById(id);
    }

    @Override
    public Page<Division> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<Division> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
