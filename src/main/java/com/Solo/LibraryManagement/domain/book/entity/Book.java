package com.Solo.LibraryManagement.domain.book.entity;

import com.Solo.LibraryManagement.domain.bookstatus.entity.BookStatus;
import com.Solo.LibraryManagement.domain.library.entity.Library;
import com.Solo.LibraryManagement.domain.loan.entity.Loan;
import com.Solo.LibraryManagement.global.audit.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;  // PK 도서 식별번호

    @Column(name = "BOOK_NAME", nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String publisher;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<BookStatus> bookStatuses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    public Book(Long bookId, String title, String author, String publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
}
