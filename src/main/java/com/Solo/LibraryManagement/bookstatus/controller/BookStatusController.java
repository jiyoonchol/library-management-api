package com.Solo.LibraryManagement.bookstatus.controller;

import com.Solo.LibraryManagement.bookstatus.dto.BookStatusPatchDto;
import com.Solo.LibraryManagement.bookstatus.dto.BookStatusPostDto;
import com.Solo.LibraryManagement.bookstatus.entity.BookStatus;
import com.Solo.LibraryManagement.bookstatus.service.BookStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bsc/status")
public class BookStatusController {

    private final BookStatusService bookStatusService;

    public BookStatusController(BookStatusService bookStatusService) {
        this.bookStatusService = bookStatusService;
    }

    @PostMapping
    private ResponseEntity postBookStatus(@RequestBody BookStatusPostDto bookStatusPostDto) {
        BookStatus bookStatus = new BookStatus();
        bookStatus.setAvailable(bookStatusPostDto.isAvailable());

        BookStatus response = bookStatusService.createBookStatus(bookStatus);
        return new ResponseEntity<>(bookStatusPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{bookStatus-id}")
    private ResponseEntity patchBookStatus(@PathVariable("bookStatus-id") long bookStatusId,
                                           @RequestBody BookStatusPatchDto bookStatusPatchDto) {
        bookStatusPatchDto.setBookStatusId(bookStatusId);
        BookStatus bookStatus = new BookStatus();
        bookStatusPatchDto.setAvailable(true);

        BookStatus response = bookStatusService.updatedBookStatus(bookStatus);

        return new ResponseEntity<>(bookStatusPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{bookStatus-id}")
    private ResponseEntity getBookStatus(@PathVariable("bookStatus-id") long bookStatusId) {
        System.out.println("# bookStatusId: " + bookStatusId);

        BookStatus response = bookStatusService.findBookStatus(bookStatusId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity getBookListStatus() {
       List<BookStatus> response = bookStatusService.findBookListStatus();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{bookStatus-id}")
    private ResponseEntity deleteBookStatus(@PathVariable("bookStatus-id") long bookStatusId) {
        System.out.println("# delete bookStatus");

        bookStatusService.deleteBookStatus(bookStatusId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
