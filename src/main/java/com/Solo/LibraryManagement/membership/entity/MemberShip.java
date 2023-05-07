package com.Solo.LibraryManagement.membership.entity;

import com.Solo.LibraryManagement.library.entity.Library;
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
public class MemberShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberShipId;

    @Column
    private boolean isActive;
    @Column
    private boolean isOverDue;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;
}
