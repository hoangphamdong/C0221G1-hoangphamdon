package com.example.model.service.impl;

import com.example.model.entity.QuestionType;
import com.example.model.repository.IQuestionTypeRepository;
import com.example.model.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QuestionTypeServiceImpl implements IQuestionTypeService {
    @Autowired
    IQuestionTypeRepository questionTypeRepository;
    @Override
    public Iterable<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Optional<QuestionType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(QuestionType questionType) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<QuestionType> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<QuestionType> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }
}
