package com.Solo.LibraryManagement.library.controller;

import com.Solo.LibraryManagement.library.dto.LibraryPatchDto;
import com.Solo.LibraryManagement.library.dto.LibraryPostDto;
import com.Solo.LibraryManagement.library.entity.Library;
import com.Solo.LibraryManagement.library.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lc/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity postLibrary(@RequestBody LibraryPostDto libraryPostDto) {
        Library library = new Library();

        library.setLibraryName(library.getLibraryName());
        library.setLibraryAddress(library.getLibraryAddress());

        Library response = libraryService.createLibrary(library);
        return new ResponseEntity<>(libraryPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{library-id}")
    public ResponseEntity patchLibrary(@PathVariable("/library-id") long libraryId,
                                       @RequestBody LibraryPatchDto libraryPatchDto) {
        libraryPatchDto.setLibraryId(libraryId);
        Library library = new Library();
        library.setLibraryName(libraryPatchDto.getLibraryName());
        library.setLibraryAddress(libraryPatchDto.getLibraryAddress());

        Library response = libraryService.updateLibrary(library);
        return new ResponseEntity<>(libraryPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{library-id}")
    public ResponseEntity getLibrary(@PathVariable("library-id") long libraryId) {
        System.out.println("# libraryId: " + libraryId);

        Library response = libraryService.findLibrary(libraryId);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getLibraries() {
        System.out.println("# get Libraries");

        List<Library> response = libraryService.findLibraries();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{library-id}")
    public ResponseEntity deleteLibrary(@PathVariable("library-id") long libraryId) {

        System.out.println("# delete book");

        libraryService.deleteLibrary(libraryId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
