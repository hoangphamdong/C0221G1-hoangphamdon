package com.example.controller;


import com.example.model.entity.BookEntity;
import com.example.model.entity.UserRentEntity;
import com.example.model.service.BookService;
import com.example.model.service.UserRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserRentService userRentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView loadIndex(Pageable pageable) {
        ModelAndView index = null;
        Page<BookEntity> listBook;
        try {
            listBook = bookService.findAll(pageable);
            index = new ModelAndView("list");
            index.addObject("listBook", listBook);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return index;
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView viewDetail(@PathVariable("id") Integer id) {
        ModelAndView detail = null;
        Optional book;
        try {
            book = bookService.findById(id);
            detail = new ModelAndView("view");
            detail.addObject("book", book);
            detail.addObject("user", new UserRentEntity());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return detail;
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.POST)
    public ModelAndView rentBook(@PathVariable("id") Integer id, @ModelAttribute("user") UserRentEntity userRent, Pageable pageable) {
        ModelAndView rent = null;
        Optional<BookEntity> book;


        try {
            book = bookService.findById(id);
            if (book.> 0) {

                userRent.setRandomCode();
                userRent.setBookByBookId(book);
                userRent.setStatus(1);
                userRentService.save(userRent);

                book.getClass().setQuantity(book.get() - 1);
                bookService.save(book);

                rent = loadIndex(pageable);
                rent.addObject("alert", "Mượn thành công");
            } else {
                System.out.println("error");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rent;
    }


    @RequestMapping(value = "/return", method = RequestMethod.GET)
    public ModelAndView loadFormReturnBook() {
        ModelAndView formReturnBook = null;
        UserRentEntity userRent;
        try {
            formReturnBook = new ModelAndView("return");
            userRent = new UserRentEntity();
            formReturnBook.addObject("user", userRent);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return formReturnBook;
    }

    @RequestMapping(value = "/return", method = RequestMethod.POST)
    public ModelAndView returnBook(@ModelAttribute("user") UserRentEntity userRent, Pageable pageable) {
        ModelAndView returnBook = null;
        BookEntity book;
        UserRentEntity currentUserRent;
        try {
            currentUserRent = userRentService.findAllByCode(userRent.getCode());
            if (currentUserRent != null && currentUserRent.getStatus() == 1) {
                book = currentUserRent.getBookByBookId();
                if (book != null) {
                    book.setQuantity(book.getQuantity() + 1);
                    bookService.save(book);

                    currentUserRent.setStatus(0);
                    userRentService.save(currentUserRent);
                } else {
                    System.out.println("Error set quantity book");
                }
            } else {
                System.out.println("Error");
            }
//            List<UserRentEntity> listUser = userRentService.findAll();
            returnBook = loadIndex(pageable);
            returnBook.addObject("alert", "Trả sách thành công");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnBook;
    }
}
