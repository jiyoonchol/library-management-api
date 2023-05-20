package com.Solo.LibraryManagement.domain.book.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookPatchDto {
    private long bookId;
    private String bookName;
    private String author;
    private String publisher;


}
