package com.example.model.service;

import com.example.model.entity.BookBorrowCard;

import java.util.List;

public interface BookBorrowCardService {
    List<BookBorrowCard> findAll();

    void save(BookBorrowCard bookBorrowCard);
}
