package com.Solo.LibraryManagement.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookResponseDto {
    private Long bookId;
    private String bookName;
    private String author;
    private String publisher;


}
