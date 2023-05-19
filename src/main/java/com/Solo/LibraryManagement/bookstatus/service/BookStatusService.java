package com.Solo.LibraryManagement.bookstatus.service;

import com.Solo.LibraryManagement.bookstatus.entity.BookStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStatusService {

    public BookStatus createBookStatus(BookStatus bookStatus) {

        BookStatus createdBookStatus = bookStatus;
        return createdBookStatus;
    }

    public BookStatus updatedBookStatus(BookStatus bookStatus) {

        BookStatus updatedBookStatus = bookStatus;
        return updatedBookStatus;
    }

    public BookStatus findBookStatus(long bookStatusId) {

        BookStatus bookStatus = new BookStatus(bookStatusId, true);

        return bookStatus;
    }

    public List<BookStatus> findBookListStatus() {

        List<BookStatus> bookListStatus = List.of(
                new BookStatus(1L, true),
                new BookStatus(2L, true)
        );

        return bookListStatus;
    }

    public void deleteBookStatus(long bookStatusId) {

    }
}
