package com.example.service;

import com.example.model.Book;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAll();

    Optional<Book> findById(Long id);

    void save(Book book);
}
