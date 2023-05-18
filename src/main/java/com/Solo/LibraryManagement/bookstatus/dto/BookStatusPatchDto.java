package com.Solo.LibraryManagement.bookstatus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookStatusPatchDto {
    private long bookStatusId;
    private boolean isAvailable;
}

