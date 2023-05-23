package com.Solo.LibraryManagement.domain.bookstatus.mapper;

import com.Solo.LibraryManagement.domain.bookstatus.dto.BookStatusPatchDto;
import com.Solo.LibraryManagement.domain.bookstatus.dto.BookStatusPostDto;
import com.Solo.LibraryManagement.domain.bookstatus.dto.BookStatusResponseDto;
import com.Solo.LibraryManagement.domain.bookstatus.entity.BookStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookStatusMapper {
    BookStatus bookStatusPostDtoToBookStatus(BookStatusPostDto bookStatusPostDto);
    BookStatus bookStatusPatchDtoToBookStatus(BookStatusPatchDto bookStatusPatchDto);

    BookStatusResponseDto bookStatusToBookStatusResponseDto(BookStatus bookStatus);

    List<BookStatusResponseDto> bookStatusToBookStatusResponseDtos(List<BookStatus> bookStatuses);
}
