package com.example.controller;

import com.example.model.entity.BookBorrowHistory;
import com.example.model.service.BookBorrowCardService;
import com.example.model.service.BookBorrowHistoryService;
import com.example.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BooksController {
    @Autowired
    BookService bookService;
    @Autowired
    BookBorrowHistoryService bookBorrowHistoryService;
    @Autowired
    BookBorrowCardService bookBorrowCardService;

    @GetMapping({"", "/list"})
    public String bookList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "book";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("bookCartList", bookBorrowCardService.findAll());
        model.addAttribute("borrowBook", new BookBorrowHistory());
        return "/create";
    }

}