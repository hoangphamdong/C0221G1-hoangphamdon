package com.example.model.entity;



import javax.persistence.*;
import java.util.List;

@Entity
public class BookBorrowCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameStudent;
    @OneToMany(mappedBy = "bookBorrowCard")
    private List<BookBorrowHistory> borrowHistoryList;

    public BookBorrowCard() {
    }

    public BookBorrowCard(int id, String nameStudent, List<BookBorrowHistory> borrowHistoryList) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.borrowHistoryList = borrowHistoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public List<BookBorrowHistory> getBorrowHistoryList() {
        return borrowHistoryList;
    }

    public void setBorrowHistoryList(List<BookBorrowHistory> borrowHistoryList) {
        this.borrowHistoryList = borrowHistoryList;
    }
}
