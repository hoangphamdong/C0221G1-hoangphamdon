package com.example.model.repository;

import com.example.model.entity.Customer;
import com.example.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends PagingAndSortingRepository<Question,Integer> {
    @Query(value = "SELECT * FROM Question where title like :title  and id_question_type like :type", nativeQuery = true)
    Page<Question> findQuestionByTitleAndQuestionType1(@Param("title") String title, @Param("type") String type, Pageable pageable);
}
