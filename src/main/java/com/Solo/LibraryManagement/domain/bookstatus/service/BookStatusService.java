package com.Solo.LibraryManagement.domain.bookstatus.service;

import com.Solo.LibraryManagement.domain.bookstatus.entity.BookStatus;
import com.Solo.LibraryManagement.domain.bookstatus.repository.BookStatusRepository;
import com.Solo.LibraryManagement.global.exception.BusinessLogicException;
import com.Solo.LibraryManagement.global.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStatusService {

    private final BookStatusRepository bookStatusRepository;

    public BookStatusService(BookStatusRepository bookStatusRepository) {
        this.bookStatusRepository = bookStatusRepository;
    }

    public BookStatus createBookStatus(BookStatus bookStatus) {

        BookStatus createdBookStatus = bookStatus;
        return createdBookStatus;
    }

    public BookStatus updatedBookStatus(BookStatus bookStatus) {

        BookStatus findBookStatus = findVerifiedBookStatus(bookStatus.getBookStatusId());
        Optional.ofNullable(bookStatus.isAvailable()).ifPresent(available -> findBookStatus.setAvailable(available));
        return bookStatusRepository.save(findBookStatus);
    }

    public BookStatus findBookStatus(long bookStatusId) {

        BookStatus findBookStatus = bookStatusRepository.findById(bookStatusId).orElseThrow(()-> new BusinessLogicException(ExceptionCode.BOOK_STATUS_NOT_FOUND));

        return bookStatusRepository.save(findBookStatus);
    }

    public Page<BookStatus> findBookListStatus(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        return bookStatusRepository.findAllByOrderByBookStatusIdDesc(pageRequest);
    }

    public void deleteBookStatus(long bookStatusId) {
        BookStatus findBookStatus = findVerifiedBookStatus(bookStatusId);
        bookStatusRepository.delete(findBookStatus);

    }

    public BookStatus findVerifiedBookStatus(long bookStatusId) {
        Optional<BookStatus> optionalBookStatus = bookStatusRepository.findById(bookStatusId);

        BookStatus findBookStatus = optionalBookStatus.orElseThrow(()-> new BusinessLogicException(ExceptionCode.BOOK_STATUS_NOT_FOUND));
        return findBookStatus;
    }
}
