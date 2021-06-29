package com.example.model.service.impl;

import com.example.model.entity.BookBorrowCard;
import com.example.model.repository.BookBorrowCardRepository;
import com.example.model.service.BookBorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowCardServiceImpl implements BookBorrowCardService {

    @Autowired
    private BookBorrowCardRepository bookBorrowCardRepository;

    @Override
    public List<BookBorrowCard> findAll() {
        return bookBorrowCardRepository.findAll();
    }

    @Override
    public void save(BookBorrowCard bookBorrowCard) {
        bookBorrowCardRepository.save(bookBorrowCard);
    }
}
