package com.Solo.LibraryManagement.domain.membership.entity;

import com.Solo.LibraryManagement.domain.library.entity.Library;
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
public class MemberShip extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberShipId;

    @Column
    private boolean isActive;
    @Column
    private boolean isOverDue;

    // 가입 날짜

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    public MemberShip(Long memberShipId, boolean isActive, boolean isOverDue) {
        this.memberShipId = memberShipId;
        this.isActive = isActive;
        this.isOverDue = isOverDue;
    }
}
