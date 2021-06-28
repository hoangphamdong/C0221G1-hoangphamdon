package com.example.model.service;


import com.example.model.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {
    public Page<BookEntity> findAll(Pageable pageable);

    public Optional findById(Integer id);

    public void save(BookEntity bookEntity);

    public void  delete(Integer id);
}