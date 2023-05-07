package com.Solo.LibraryManagement.book.entity;

import com.Solo.LibraryManagement.bookstatus.entity.BookStatus;
import com.Solo.LibraryManagement.library.entity.Library;
import com.Solo.LibraryManagement.loan.entity.Loan;
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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;  // PK 도서 식별번호

    @Column(name = "BOOK_NAME", nullable = false)
    private String bookName;
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

}
