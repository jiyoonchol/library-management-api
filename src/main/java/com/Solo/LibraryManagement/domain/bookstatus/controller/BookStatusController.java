package com.Solo.LibraryManagement.domain.bookstatus.controller;

import com.Solo.LibraryManagement.domain.bookstatus.dto.BookStatusPatchDto;
import com.Solo.LibraryManagement.domain.bookstatus.dto.BookStatusPostDto;
import com.Solo.LibraryManagement.domain.bookstatus.dto.BookStatusResponseDto;
import com.Solo.LibraryManagement.domain.bookstatus.entity.BookStatus;
import com.Solo.LibraryManagement.domain.bookstatus.mapper.BookStatusMapper;
import com.Solo.LibraryManagement.domain.bookstatus.service.BookStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bsc/status")
public class BookStatusController {

    private final BookStatusService bookStatusService;
    private final BookStatusMapper bookStatusMapper;

    public BookStatusController(BookStatusService bookStatusService, BookStatusMapper bookStatusMapper) {
        this.bookStatusService = bookStatusService;
        this.bookStatusMapper = bookStatusMapper;
    }

    @PostMapping
    private ResponseEntity postBookStatus(@RequestBody BookStatusPostDto bookStatusPostDto) {

        BookStatus bookStatus = bookStatusMapper.bookStatusPostDtoToBookStatus(bookStatusPostDto);

        BookStatus response = bookStatusService.createBookStatus(bookStatus);
        return new ResponseEntity<>(bookStatusMapper.bookStatusToBookStatusResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{bookStatus-id}")
    private ResponseEntity patchBookStatus(@PathVariable("bookStatus-id") @Positive long bookStatusId,
                                           @RequestBody BookStatusPatchDto bookStatusPatchDto) {
        bookStatusPatchDto.setBookStatusId(bookStatusId);

        BookStatus response = bookStatusService.updatedBookStatus(bookStatusMapper.bookStatusPatchDtoToBookStatus(bookStatusPatchDto));

        return new ResponseEntity<>(bookStatusMapper.bookStatusToBookStatusResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{bookStatus-id}")
    private ResponseEntity getBookStatus(@PathVariable("bookStatus-id") @Positive long bookStatusId) {

        BookStatus response = bookStatusService.findBookStatus(bookStatusId);
        return new ResponseEntity<>(bookStatusMapper.bookStatusToBookStatusResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity getBookListStatus() {
       List<BookStatus> bookListStatus = bookStatusService.findBookListStatus();

        List<BookStatusResponseDto> response =
                bookListStatus.stream()
                        .map(bookStatus -> bookStatusMapper.bookStatusToBookStatusResponseDto(bookStatus))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{bookStatus-id}")
    private ResponseEntity deleteBookStatus(@PathVariable("bookStatus-id") @Positive long bookStatusId) {
        System.out.println("# delete bookStatus");

        bookStatusService.deleteBookStatus(bookStatusId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
