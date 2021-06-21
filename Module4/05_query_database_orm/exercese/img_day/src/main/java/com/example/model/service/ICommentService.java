package com.example.model.service;

import com.example.model.entity.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment>findAll();
    void save(Comment comment);
    Comment update(Comment comment);
    Comment like (Long id);
    Comment findById(Long id);
}
