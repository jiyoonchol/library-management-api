package com.Solo.LibraryManagement.domain.library.entity;

import com.Solo.LibraryManagement.domain.book.entity.Book;
import com.Solo.LibraryManagement.domain.membership.entity.MemberShip;
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
public class Library extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libraryId;

    @Column(name = "LIBRARY_NAME")
    private String libraryName;

    @Column
    private String libraryAddress;

    @OneToMany(mappedBy = "library")
    private List<MemberShip> memberShips = new ArrayList<>();

    @OneToMany(mappedBy = "library")
    private List<Book> books = new ArrayList<>();

    public Library(Long libraryId, String libraryName, String libraryAddress) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
    }
}
