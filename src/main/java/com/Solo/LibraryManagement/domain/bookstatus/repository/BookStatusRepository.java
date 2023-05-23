package com.Solo.LibraryManagement.domain.bookstatus.repository;

import com.Solo.LibraryManagement.domain.bookstatus.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStatusRepository extends JpaRepository<BookStatus, Long> {
}
