package com.Solo.LibraryManagement.domain.loan.entity;

import com.Solo.LibraryManagement.domain.book.entity.Book;
import com.Solo.LibraryManagement.domain.bookstatus.entity.BookStatus;
import com.Solo.LibraryManagement.domain.member.entity.Member;
import com.Solo.LibraryManagement.global.audit.BaseTime;
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
public class Loan extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column
    private boolean isOverdue;
    @Column
    private boolean isReturned;
    @Column
    private String dueDate;
    // ㄷ ㅐ출 시작일, 반납 시간

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;

    @OneToOne
    @JoinColumn(name = "bookstatus_id")
    private BookStatus bookStatus;

    public Loan(Long loanId, boolean isOverdue, boolean isReturned, String dueDate) {
        this.loanId = loanId;
        this.isOverdue = isOverdue;
        this.isReturned = isReturned;
        this.dueDate = dueDate;
    }
}
