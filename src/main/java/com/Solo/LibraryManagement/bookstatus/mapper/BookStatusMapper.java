package com.Solo.LibraryManagement.bookstatus.mapper;

import com.Solo.LibraryManagement.bookstatus.dto.BookStatusPatchDto;
import com.Solo.LibraryManagement.bookstatus.dto.BookStatusPostDto;
import com.Solo.LibraryManagement.bookstatus.dto.BookStatusResponseDto;
import com.Solo.LibraryManagement.bookstatus.entity.BookStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookStatusMapper {
    BookStatus bookStatusPostDtoToBookStatus(BookStatusPostDto bookStatusPostDto);
    BookStatus bookStatusPatchDtoToBookStatus(BookStatusPatchDto bookStatusPatchDto);

    BookStatusResponseDto bookStatusToBookStatusResponseDto(BookStatus bookStatus);
}
