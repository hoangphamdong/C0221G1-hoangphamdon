package com.example.model.entity;



import javax.persistence.*;
@Entity
public class BookBorrowHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
    private BookBorrowCard bookBorrowCard;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    private String dateBorrow;

    public BookBorrowHistory() {
    }

    public BookBorrowHistory(int id, BookBorrowCard bookBorrowCard, Book book, String dateBorrow) {
        this.id = id;
        this.bookBorrowCard = bookBorrowCard;
        this.book = book;
        this.dateBorrow = dateBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }
}
