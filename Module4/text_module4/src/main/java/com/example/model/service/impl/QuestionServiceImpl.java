package com.example.model.service.impl;

import com.example.model.entity.Customer;
import com.example.model.entity.Question;
import com.example.model.repository.IQuestionRepository;
import com.example.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    IQuestionRepository questionRepository;
    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
questionRepository.save(question);
    }

    @Override
    public void remove(Integer id) {
questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> pageAndSearch(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Page<Question> pageAndSearchBirthday(String keyword, String birthday, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Question> getQuestionByTitleAndType(String title, String type, Pageable pageable) {
        return questionRepository.findQuestionByTitleAndQuestionType1("%"+title+"%","%"+type+"%",pageable);
    }
}
