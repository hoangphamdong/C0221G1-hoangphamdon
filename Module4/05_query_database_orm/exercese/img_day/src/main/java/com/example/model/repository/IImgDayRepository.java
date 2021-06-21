package com.example.model.repository;

import com.example.model.entity.Comment;

import java.util.List;

public interface IImgDayRepository {
    List<Comment> findAll();
    void save(Comment comment);
    Comment update(Comment comment);
    Comment like (Long id);
    Comment findById(Long id);
}
