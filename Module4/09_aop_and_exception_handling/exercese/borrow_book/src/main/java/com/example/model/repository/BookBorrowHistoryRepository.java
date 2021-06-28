package com.example.model.repository;

import com.example.model.entity.BookBorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowHistoryRepository extends JpaRepository<BookBorrowHistory,Integer> {
}
