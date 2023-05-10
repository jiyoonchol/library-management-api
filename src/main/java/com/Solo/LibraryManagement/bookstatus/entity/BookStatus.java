package com.Solo.LibraryManagement.bookstatus.entity;

import com.Solo.LibraryManagement.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookStatusId;

    @Column
    private boolean isAvailable;
    @Column
    private boolean isUnAvailable;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
