package com.Solo.LibraryManagement.library.entity;

import com.Solo.LibraryManagement.book.entity.Book;
import com.Solo.LibraryManagement.membership.entity.MemberShip;
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
public class Library {

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
}
