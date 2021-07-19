package com.example.model.service;

import com.example.model.entity.Customer;
import com.example.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends IService<Question> {
    Page<Question> getQuestionByTitleAndType(String title, String type, Pageable pageable);
}
