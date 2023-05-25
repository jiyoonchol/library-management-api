package com.Solo.LibraryManagement.domain.book.repository;

import com.Solo.LibraryManagement.domain.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAllByOrderByBookIdDesc(Pageable pageable);
    List<Book> findByTitleContaining(String keyword, Pageable pageable);
}
