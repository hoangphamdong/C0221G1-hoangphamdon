package com.example.model.repository;

import com.example.model.entity.QuestionType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionTypeRepository extends PagingAndSortingRepository<QuestionType,Integer> {
}
