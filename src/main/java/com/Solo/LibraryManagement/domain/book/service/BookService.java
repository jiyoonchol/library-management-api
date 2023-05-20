package com.Solo.LibraryManagement.domain.book.service;

import com.Solo.LibraryManagement.domain.book.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public Book createBook(Book book) {
        Book createdBook = book;
        return createdBook;
    }

    public Book updateBook(Book book) {
        Book updatedBook = book;
        return updatedBook;
    }

    public Book findBook(long bookId) {
        Book book = new Book(bookId, "book", "author", "publisher");
        return book;
    }

    public List<Book> findBooks() {
        List<Book> books = List.of(
                new Book(1L, "book1", "author1", "publisher1"),
                new Book(2L, "book2", "author2", "publisher2")
        );
        return books;
    }

    public void deleteBook(long bookId) {

    }
}
