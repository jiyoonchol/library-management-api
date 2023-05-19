package com.Solo.LibraryManagement.book.controller;

import com.Solo.LibraryManagement.book.dto.BookPatchDto;
import com.Solo.LibraryManagement.book.dto.BookPostDto;
import com.Solo.LibraryManagement.book.entity.Book;
import com.Solo.LibraryManagement.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(value = "/b1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity postBook(@RequestBody BookPostDto bookPostDto) {
        Book book = new Book();
        book.setBookName(bookPostDto.getBookName());
        book.setAuthor(bookPostDto.getAuthor());
        book.setPublisher(bookPostDto.getPublisher());

        Book response = bookService.createBook(book);
        return new ResponseEntity<>(bookPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{book-id}")
    public ResponseEntity patchBook(@PathVariable("book-id") long bookId,
                                    @RequestBody BookPatchDto bookPatchDto) {
        bookPatchDto.setBookId(bookId);
        Book book = new Book();
        book.setBookId(bookPatchDto.getBookId());
        book.setBookName(bookPatchDto.getBookName());
        book.setAuthor(book.getAuthor());
        book.setPublisher(book.getPublisher());

        Book response = bookService.updateBook(book);
        return new ResponseEntity<>(bookPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{book-id}")
    public ResponseEntity getBook(@PathVariable("book-id") long bookId) {
        System.out.println("# bookId: " + bookId);

        Book response = bookService.findBook(bookId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getBooks() {
        List<Book> response = bookService.findBooks();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{book-id}")
    public ResponseEntity deleteBook(@PathVariable("book-id") @Positive long bookId) {

        System.out.println("# delete book");

        bookService.deleteBook(bookId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
