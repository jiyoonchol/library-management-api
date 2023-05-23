package com.Solo.LibraryManagement.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookResponseDto {
    private Long bookId;
    private String title;
    private String author;
    private String publisher;


}
