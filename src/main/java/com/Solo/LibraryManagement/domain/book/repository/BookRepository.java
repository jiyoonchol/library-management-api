package com.Solo.LibraryManagement.domain.book.repository;

import com.Solo.LibraryManagement.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
