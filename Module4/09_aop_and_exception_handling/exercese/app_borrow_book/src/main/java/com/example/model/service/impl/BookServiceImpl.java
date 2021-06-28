package com.example.model.service.impl;

import com.example.model.entity.BookEntity;
import com.example.model.repository.BookRepository;
import com.example.model.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<BookEntity> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
