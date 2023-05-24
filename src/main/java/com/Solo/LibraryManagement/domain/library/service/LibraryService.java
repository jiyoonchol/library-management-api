package com.Solo.LibraryManagement.domain.library.service;

import com.Solo.LibraryManagement.domain.library.entity.Library;
import com.Solo.LibraryManagement.domain.library.repository.LibraryRepository;
import com.Solo.LibraryManagement.global.exception.BusinessLogicException;
import com.Solo.LibraryManagement.global.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Library createLibrary(Library library) {
        verifyExitsName(library.getName());
        return libraryRepository.save(library);
    }

    public Library updateLibrary(Library library) {
        Library findLibrary = findVerifiedLibrary(library.getLibraryId());

        Optional.ofNullable(library.getName())
                .ifPresent(name -> findLibrary.setName(name));
        Optional.ofNullable(library.getAddress())
                .ifPresent(address -> findLibrary.setAddress(address));


        return libraryRepository.save(findLibrary);
    }

    public Library findLibrary(long libraryId) {
        return findVerifiedLibrary(libraryId);
    }

    public Page<Library> findLibraries(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return libraryRepository.findAllByOrderByLibraryIdDesc(pageRequest);

    }

    public void deleteLibrary(long libraryId) {
        Library findLibrary = findVerifiedLibrary(libraryId);
        libraryRepository.delete(findLibrary);
    }

    public Library findVerifiedLibrary(long libraryId) {
        Optional<Library> optionalLibrary = libraryRepository.findById(libraryId);
        Library findLibrary = optionalLibrary.orElseThrow(() -> new BusinessLogicException(ExceptionCode.LIBRARY_NOT_FOUND));
        return findLibrary;
    }

    public void verifyExitsName(String name) {
        Optional<Library> library = libraryRepository.findByName(name);
        if (library.isPresent())
            throw new BusinessLogicException(ExceptionCode.LIBRARY_EXISTS);
    }
}
