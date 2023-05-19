package com.Solo.LibraryManagement.library.service;

import com.Solo.LibraryManagement.library.entity.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    public Library createLibrary(Library library) {
        Library createdLibrary = library;
        return createdLibrary;
    }

    public Library updateLibrary(Library library) {
        Library updatedLibrary = library;

        return updatedLibrary;
    }

    public Library findLibrary(long libraryId) {
        Library library = new Library(libraryId, "library", "address");
        return library;

    }

    public List<Library> findLibraries() {
        List<Library> libraries = List.of(
                new Library(1L, "library1", "address1"),
                new Library(2L, "library2", "address2")
        );

        return libraries;
    }

    public void deleteLibrary(long libraryId) {

    }
}
