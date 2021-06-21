package com.example.model.repository.impl;

import com.example.model.entity.Comment;
import com.example.model.repository.IImgDayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgDayRepository implements IImgDayRepository {
    @Override
    public List<Comment> findAll() {
        return BaseRepository.entityManager.createQuery("select c from comment c ",
                Comment.class).getResultList();
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
