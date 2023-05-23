package com.Solo.LibraryManagement.domain.book.service;

import com.Solo.LibraryManagement.domain.book.entity.Book;
import com.Solo.LibraryManagement.domain.book.repository.BookRepository;
import com.Solo.LibraryManagement.global.exception.BusinessLogicException;
import com.Solo.LibraryManagement.global.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Book findBook = findVerifiedBook(book.getBookId());
        Optional.ofNullable(book.getTitle()).ifPresent(title -> findBook.setTitle(title));
        Optional.ofNullable(book.getAuthor()).ifPresent(author -> findBook.setAuthor(author));
        Optional.ofNullable(book.getPublisher()).ifPresent(publisher -> findBook.setPublisher(publisher));
        return bookRepository.save(findBook);
    }

    public Book findBook(long bookId) {
        Book findBook = bookRepository.findById(bookId).orElseThrow(()-> new BusinessLogicException(ExceptionCode.BOOK_NOT_FOUND));
        return bookRepository.save(findBook);
    }

    public Page<Book> findBooks(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return bookRepository.findAllByOrderByBookIdDesc(pageRequest);
    }

    public Book findVerifiedBook(long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Book findBook = optionalBook.orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOOK_NOT_FOUND));
        return findBook;
    }

    public void deleteBook(long bookId) {
        Book findBook = findVerifiedBook(bookId);
        bookRepository.delete(findBook);
    }
}
