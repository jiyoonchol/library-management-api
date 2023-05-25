package com.Solo.LibraryManagement.domain.book.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookPostDto {
    private String title;
    private String author;
    private String publisher;
}
