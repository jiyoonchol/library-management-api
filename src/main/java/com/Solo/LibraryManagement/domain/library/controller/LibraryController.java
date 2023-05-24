package com.Solo.LibraryManagement.domain.library.controller;

import com.Solo.LibraryManagement.domain.library.dto.LibraryPatchDto;
import com.Solo.LibraryManagement.domain.library.dto.LibraryPostDto;
import com.Solo.LibraryManagement.domain.library.dto.LibraryResponseDto;
import com.Solo.LibraryManagement.domain.library.entity.Library;
import com.Solo.LibraryManagement.domain.library.mapper.LibraryMapper;
import com.Solo.LibraryManagement.domain.library.service.LibraryService;
import com.Solo.LibraryManagement.global.response.PageResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lc/library")
public class LibraryController {

    private final LibraryService libraryService;
    private final LibraryMapper libraryMapper;

    public LibraryController(LibraryService libraryService, LibraryMapper libraryMapper) {
        this.libraryService = libraryService;
        this.libraryMapper = libraryMapper;
    }

    @PostMapping
    public ResponseEntity postLibrary(@RequestBody LibraryPostDto libraryPostDto) {
        Library library = libraryMapper.libraryToLibraryPostDto(libraryPostDto);



        Library response = libraryService.createLibrary(library);
        return new ResponseEntity<>(libraryMapper.libraryToLibraryResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{library-id}")
    public ResponseEntity patchLibrary(@PathVariable("library-id") @Positive long libraryId,
                                       @RequestBody LibraryPatchDto libraryPatchDto) {
        libraryPatchDto.setLibraryId(libraryId);



        Library response = libraryService.updateLibrary(libraryMapper.libraryToLibraryPatchDto(libraryPatchDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{library-id}")
    public ResponseEntity getLibrary(@PathVariable("library-id") @Positive long libraryId) {


        Library response = libraryService.findLibrary(libraryId);
        return new ResponseEntity(libraryMapper.libraryToLibraryResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getLibraries(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size) {

        Page<Library> pageLibraries = libraryService.findLibraries(page - 1, size);
        List<Library> libraries = pageLibraries.getContent();

        return new ResponseEntity<>(
                new PageResponseDto<>(libraryMapper.librariesToLibraryResponseDtos(libraries), pageLibraries), HttpStatus.OK);

    }

    @DeleteMapping("/{library-id}")
    public ResponseEntity deleteLibrary(@PathVariable("library-id") @Positive long libraryId) {

        System.out.println("# delete book");

        libraryService.deleteLibrary(libraryId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
