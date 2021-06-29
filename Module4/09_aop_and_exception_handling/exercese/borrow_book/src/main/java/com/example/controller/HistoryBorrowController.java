package com.example.controller;

import com.example.model.entity.Book;
import com.example.model.entity.BookBorrowHistory;
import com.example.model.service.BookBorrowCardService;
import com.example.model.service.BookBorrowHistoryService;
import com.example.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrow")
public class HistoryBorrowController {
    @Autowired
    BookService bookService;
    @Autowired
    BookBorrowHistoryService bookBorrowHistoryService;
    @Autowired
    BookBorrowCardService bookBorrowCardService;

    @GetMapping("/list")
    public String historyBorrowBook(Model model){
        model.addAttribute("borrowList",bookBorrowHistoryService.findAll());
        return "detail";
    }
    @PostMapping("/create")
    public String showBorrowBook(Model model, @ModelAttribute("borrowBook") BookBorrowHistory bookBorrowHistory, RedirectAttributes redirectAttributes){
        if (bookBorrowHistory.getBook().getQuantity() == 0){
            model.addAttribute("bookList",bookService.findAll());
            model.addAttribute("bookCartList",bookBorrowCardService.findAll());
            model.addAttribute("borrowBook", new BookBorrowHistory());
            model.addAttribute("message","hết sách rồi, mượn sách khác đi!!");
            return "create";
        } else {
            Book book = bookBorrowHistory.getBook();
            book.setQuantity(book.getQuantity()-1);
            bookService.save(book);
            bookBorrowHistoryService.save(bookBorrowHistory);
            redirectAttributes.addFlashAttribute("message","đã mượn sách");
            return "redirect:/borrow/list";
        }
    }
    @GetMapping("/{id}/view")
    public String borrowBook(@PathVariable Integer id, Model model){
        model.addAttribute("history",bookBorrowHistoryService.findById(id));
        return "view";
    }
    @GetMapping("/{id}/delete")
    public String deleteBorrowBook(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        Book book = bookBorrowHistoryService.findById(id).getBook();
        book.setQuantity(book.getQuantity()+1);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","đã trả sách");
        bookBorrowHistoryService.remove(id);
        return "redirect:/book/list";
    }
}