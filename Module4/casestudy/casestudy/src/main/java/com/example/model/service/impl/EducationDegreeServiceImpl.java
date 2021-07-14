package com.example.model.service.impl;

import com.example.model.entity.EducationDegree;
import com.example.model.repository.IEducationDegreeRepository;
import com.example.model.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;


    @Override
    public Iterable<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Optional<EducationDegree> findById(Integer id) {
        return educationDegreeRepository.findById(id).empty();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(Integer id) {
        educationDegreeRepository.deleteById(id);
    }

    @Override
    public Page<EducationDegree> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<EducationDegree> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }


}
