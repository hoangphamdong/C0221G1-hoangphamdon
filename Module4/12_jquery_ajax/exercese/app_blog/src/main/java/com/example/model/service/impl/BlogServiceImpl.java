package com.example.model.service.impl;

import com.example.model.entity.Blog;
import com.example.model.repository.BlogRepository;
import com.example.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
//        return blogRepository.findAll();
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> sortWriteDate(Pageable pageable) {
        return null;
    }


    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllInputText(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAllByOrderByWriteDate(pageable);
    }

    @Override
    public int getTotalPages() {
        return 0;
    }
}

