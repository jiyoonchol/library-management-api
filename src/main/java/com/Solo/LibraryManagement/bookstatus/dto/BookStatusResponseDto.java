package com.Solo.LibraryManagement.bookstatus.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookStatusResponseDto {
    private long bookStatusId;
    private boolean isAvailable;
}
