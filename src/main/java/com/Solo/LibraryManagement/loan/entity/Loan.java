package com.Solo.LibraryManagement.loan.entity;

import com.Solo.LibraryManagement.book.entity.Book;
import com.Solo.LibraryManagement.bookstatus.entity.BookStatus;
import com.Solo.LibraryManagement.member.entity.Member;
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
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column
    private boolean isOverdue;
    @Column
    private boolean isReturned;
    @Column
    private String dueDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;

    @OneToOne
    @JoinColumn(name = "bookstatus_id")
    private BookStatus bookStatus;
}
