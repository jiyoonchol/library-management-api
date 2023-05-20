package com.Solo.LibraryManagement.book.mapper;

import com.Solo.LibraryManagement.book.dto.BookPatchDto;

import com.Solo.LibraryManagement.book.dto.BookPostDto;
import com.Solo.LibraryManagement.book.dto.BookResponseDto;
import com.Solo.LibraryManagement.book.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book bookPostDtoToBook(BookPostDto bookPostDto);

    Book bookPatchDtoToBook(BookPatchDto bookPatchDto);

    BookResponseDto bookToBookResponseDto(Book book);
}
