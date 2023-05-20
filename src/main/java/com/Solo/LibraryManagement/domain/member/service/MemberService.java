package com.Solo.LibraryManagement.domain.member.service;

import com.Solo.LibraryManagement.domain.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member) {
        Member createdMember = member;
        return createdMember;
    }

    public Member updateMember(Member member) {
        Member updatedMember = member;
        return updatedMember;
    }

    public Member findMember(long memberId) {

        Member member = new Member(memberId, "mark", "010-1234-5678", "address");
        return member;
    }

    public List<Member> findMembers() {
        List<Member> members = List.of(
                new Member(1L, "mark", "010-1234-5678", "address"),
                new Member(2L, "zeno", "010-5678-1234", "address2"));

        return members;
    }

    public void deleteMember(long memberId) {

    }
}
