package com.example.create_app_blog.model.service.impl;

import com.example.create_app_blog.model.entity.Blog;
import com.example.create_app_blog.model.repository.IBlogRepository;
import com.example.create_app_blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService<Blog> {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog model) {
        blogRepository.save(model);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }
}
