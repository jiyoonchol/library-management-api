package com.Solo.LibraryManagement.member.entity;

import com.Solo.LibraryManagement.loan.entity.Loan;
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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column
    private String memberName;
    @Column
    private String phoneNumber;
    @Column
    private String memberAddress;

    @OneToMany(mappedBy = "member")
    private List<Loan> loans = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberShip> memberShips = new ArrayList<>();

    public Member(Long memberId, String memberName, String phoneNumber, String memberAddress) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.memberAddress = memberAddress;
    }
}
