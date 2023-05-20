package com.Solo.LibraryManagement.library.mapper;

import com.Solo.LibraryManagement.library.dto.LibraryPatchDto;
import com.Solo.LibraryManagement.library.dto.LibraryPostDto;
import com.Solo.LibraryManagement.library.dto.LibraryResponseDto;
import com.Solo.LibraryManagement.library.entity.Library;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {
    Library libraryToLibraryPostDto(LibraryPostDto libraryPostDto);
    Library libraryToLibraryPatchDto(LibraryPatchDto libraryPatchDto);
    LibraryResponseDto libraryToLibraryResponseDto(Library library);
}
