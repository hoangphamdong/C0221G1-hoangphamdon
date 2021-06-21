package com.example.model.service.impl;

import com.example.model.entity.Comment;
import com.example.model.repository.IImgDayRepository;
import com.example.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
   @Autowired
    IImgDayRepository iImgDayRepository;
    @Override
    public List<Comment> findAll() {
        return iImgDayRepository.findAll();
    }

    @Override
    public void save(Comment comment) {

    }

    @Override
    public Comment update(Comment comment) {
        return null;
    }

    @Override
    public Comment like(Long id) {
        return null;
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }
}
