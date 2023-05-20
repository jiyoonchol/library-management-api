package com.Solo.LibraryManagement.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LibraryResponseDto {
    private long libraryId;
    private String libraryName;
    private String libraryAddress;
}
