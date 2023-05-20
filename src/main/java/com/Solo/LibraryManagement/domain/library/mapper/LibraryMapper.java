package com.Solo.LibraryManagement.domain.library.mapper;

import com.Solo.LibraryManagement.domain.library.dto.LibraryPatchDto;
import com.Solo.LibraryManagement.domain.library.dto.LibraryResponseDto;
import com.Solo.LibraryManagement.domain.library.entity.Library;
import com.Solo.LibraryManagement.domain.library.dto.LibraryPostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {
    Library libraryToLibraryPostDto(LibraryPostDto libraryPostDto);
    Library libraryToLibraryPatchDto(LibraryPatchDto libraryPatchDto);
    LibraryResponseDto libraryToLibraryResponseDto(Library library);
}
