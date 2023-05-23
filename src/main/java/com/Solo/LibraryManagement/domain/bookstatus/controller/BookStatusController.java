package com.Solo.LibraryManagement.domain.bookstatus.controller;

import com.Solo.LibraryManagement.domain.bookstatus.dto.BookStatusPatchDto;
import com.Solo.LibraryManagement.domain.bookstatus.dto.BookStatusPostDto;
import com.Solo.LibraryManagement.domain.bookstatus.dto.BookStatusResponseDto;
import com.Solo.LibraryManagement.domain.bookstatus.entity.BookStatus;
import com.Solo.LibraryManagement.domain.bookstatus.mapper.BookStatusMapper;
import com.Solo.LibraryManagement.domain.bookstatus.service.BookStatusService;
import com.Solo.LibraryManagement.global.response.PageResponseDto;
import org.springframework.data.domain.Page;
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
    public ResponseEntity postBookStatus(@RequestBody BookStatusPostDto bookStatusPostDto) {

        BookStatus bookStatus = bookStatusMapper.bookStatusPostDtoToBookStatus(bookStatusPostDto);

        BookStatus response = bookStatusService.createBookStatus(bookStatus);
        return new ResponseEntity<>(bookStatusMapper.bookStatusToBookStatusResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{bookStatus-id}")
    public ResponseEntity patchBookStatus(@PathVariable("bookStatus-id") @Positive long bookStatusId,
                                           @RequestBody BookStatusPatchDto bookStatusPatchDto) {
        bookStatusPatchDto.setBookStatusId(bookStatusId);

        BookStatus response = bookStatusService.updatedBookStatus(bookStatusMapper.bookStatusPatchDtoToBookStatus(bookStatusPatchDto));

        return new ResponseEntity<>(bookStatusMapper.bookStatusToBookStatusResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{bookStatus-id}")
    public ResponseEntity getBookStatus(@PathVariable("bookStatus-id") @Positive long bookStatusId) {

        BookStatus response = bookStatusService.findBookStatus(bookStatusId);
        return new ResponseEntity<>(bookStatusMapper.bookStatusToBookStatusResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getBookListStatus(@Positive @RequestParam int page,
                                             @Positive @RequestParam int size) {
        Page<BookStatus> pageBookStatuses = bookStatusService.findBookListStatus(page - 1, size);
        List<BookStatus> bookStatuses = pageBookStatuses.getContent();

        return new ResponseEntity<>(
                new PageResponseDto<>(bookStatusMapper.bookStatusToBookStatusResponseDtos(bookStatuses), pageBookStatuses), HttpStatus.OK);

    }

    @DeleteMapping("/{bookStatus-id}")
    public ResponseEntity deleteBookStatus(@PathVariable("bookStatus-id") @Positive long bookStatusId) {
        System.out.println("# delete bookStatus");

        bookStatusService.deleteBookStatus(bookStatusId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
