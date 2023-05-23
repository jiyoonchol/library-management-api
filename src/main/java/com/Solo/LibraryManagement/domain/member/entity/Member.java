package com.Solo.LibraryManagement.domain.member.entity;

import com.Solo.LibraryManagement.domain.loan.entity.Loan;
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
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    @Column
    private String name;
    @Column
    private String phoneNumber;
    @Column
    private String address;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    @OneToMany(mappedBy = "member")
    private List<Loan> loans = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberShip> memberShips = new ArrayList<>();

    public Member(Long memberId, String email, String name, String phoneNumber, String address) {
        this.memberId = memberId;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}
