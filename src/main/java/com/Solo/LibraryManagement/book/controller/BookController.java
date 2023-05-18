package com.Solo.LibraryManagement.book.controller;

import com.Solo.LibraryManagement.book.dto.BookPatchDto;
import com.Solo.LibraryManagement.book.dto.BookPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/b1/books")
public class BookController {
    @PostMapping
    public ResponseEntity postBook(@RequestBody BookPostDto bookPostDto) {


        return new ResponseEntity<>(bookPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{book-id}")
    public ResponseEntity patchBook(@PathVariable("book-id") long bookId,
                                    @RequestBody BookPatchDto bookPatchDto) {
        bookPatchDto.setBookId(bookId);
        bookPatchDto.setBookName("Book");
        bookPatchDto.setAuthor("Author");
        bookPatchDto.setPublisher("Publisher");
        return new ResponseEntity<>(bookPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{book-id}")
    public ResponseEntity getBook(@PathVariable("book-id") long bookId) {
        System.out.println("# bookId: " + bookId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getBooks() {
        System.out.println("# get Books");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{book-id}")
    public ResponseEntity deleteBook(@PathVariable("book-id") long bookId) {

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
