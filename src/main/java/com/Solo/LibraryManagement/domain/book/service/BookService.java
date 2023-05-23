package com.Solo.LibraryManagement.domain.book.service;

import com.Solo.LibraryManagement.domain.book.entity.Book;
import com.Solo.LibraryManagement.domain.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
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
