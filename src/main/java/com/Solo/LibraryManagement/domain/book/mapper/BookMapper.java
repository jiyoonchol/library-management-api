package com.Solo.LibraryManagement.domain.book.mapper;

import com.Solo.LibraryManagement.domain.book.dto.BookPatchDto;

import com.Solo.LibraryManagement.domain.book.dto.BookPostDto;
import com.Solo.LibraryManagement.domain.book.dto.BookResponseDto;
import com.Solo.LibraryManagement.domain.book.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book bookPostDtoToBook(BookPostDto bookPostDto);

    Book bookPatchDtoToBook(BookPatchDto bookPatchDto);

    BookResponseDto bookToBookResponseDto(Book book);

    List<BookResponseDto> booksToBookResponseDtos(List<Book> books);
}
