package com.example.create_app_blog.model.service.impl;

import com.example.create_app_blog.model.entity.Blog;
import com.example.create_app_blog.model.repository.IBlogRepository;
import com.example.create_app_blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog model) {
        blogRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String name,Pageable pageable) {
        return blogRepository.findAllByTitleContaining(name,pageable);
    }
}
