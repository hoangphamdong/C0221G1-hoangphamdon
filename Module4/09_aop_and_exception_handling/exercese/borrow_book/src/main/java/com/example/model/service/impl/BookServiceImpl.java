package com.example.model.service.impl;

import com.example.model.entity.Book;
import com.example.model.repository.BookRepository;
import com.example.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository booksRepository;

    @Override
    public List<Book> findAll() {
        return this.booksRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        booksRepository.deleteById(id);
    }

}

