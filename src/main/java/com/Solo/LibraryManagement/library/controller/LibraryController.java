package com.Solo.LibraryManagement.library.controller;

import com.Solo.LibraryManagement.library.dto.LibraryPatchDto;
import com.Solo.LibraryManagement.library.dto.LibraryPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lc/library")
public class LibraryController {
    @PostMapping
    public ResponseEntity postLibrary(@RequestBody LibraryPostDto libraryPostDto) {
        return new ResponseEntity<>(libraryPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{library-id}")
    public ResponseEntity patchLibrary(@PathVariable("/library-id") long libraryId,
                                       @RequestBody LibraryPatchDto libraryPatchDto) {
        libraryPatchDto.setLibraryId(libraryId);
        libraryPatchDto.setLibraryAddress("LibraryAddress");
        return new ResponseEntity<>(libraryPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{library-id}")
    public ResponseEntity getLibrary(@PathVariable("library-id") long libraryId) {
        System.out.println("# libraryId: " + libraryId);
        return new ResponseEntity(libraryId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getLibraries() {
        System.out.println("# get Libraries");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{library-id}")
    public ResponseEntity deleteLibrary(@PathVariable("library-id") long libraryId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
