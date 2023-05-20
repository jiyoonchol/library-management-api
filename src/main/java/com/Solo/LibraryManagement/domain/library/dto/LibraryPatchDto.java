package com.Solo.LibraryManagement.domain.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibraryPatchDto {
    private long libraryId;
    private String libraryName;
    private String libraryAddress;
}