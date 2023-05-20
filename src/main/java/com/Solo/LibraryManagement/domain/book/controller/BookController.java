package com.Solo.LibraryManagement.domain.book.controller;

import com.Solo.LibraryManagement.domain.book.dto.BookPatchDto;
import com.Solo.LibraryManagement.domain.book.dto.BookPostDto;
import com.Solo.LibraryManagement.domain.book.dto.BookResponseDto;
import com.Solo.LibraryManagement.domain.book.entity.Book;
import com.Solo.LibraryManagement.domain.book.mapper.BookMapper;
import com.Solo.LibraryManagement.domain.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/b1/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public ResponseEntity postBook(@RequestBody BookPostDto bookPostDto) {
        Book book = bookMapper.bookPostDtoToBook(bookPostDto);
        Book response = bookService.createBook(book);
        return new ResponseEntity<>(bookMapper.bookToBookResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{book-id}")
    public ResponseEntity patchBook(@PathVariable("book-id") @Positive long bookId,
                                    @RequestBody BookPatchDto bookPatchDto) {
        bookPatchDto.setBookId(bookId);


        Book response = bookService.updateBook(bookMapper.bookPatchDtoToBook(bookPatchDto));
        return new ResponseEntity<>(bookMapper.bookToBookResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{book-id}")
    public ResponseEntity getBook(@PathVariable("book-id") @Positive long bookId) {

        Book response = bookService.findBook(bookId);
        return new ResponseEntity<>(bookMapper.bookToBookResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getBooks() {
        List<Book> books = bookService.findBooks();
        List<BookResponseDto> response =
                books.stream()
                        .map(book -> bookMapper.bookToBookResponseDto(book))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{book-id}")
    public ResponseEntity deleteBook(@PathVariable("book-id") @Positive long bookId) {

        System.out.println("# delete book");

        bookService.deleteBook(bookId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
