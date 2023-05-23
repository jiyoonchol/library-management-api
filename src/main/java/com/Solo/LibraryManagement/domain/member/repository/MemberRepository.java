package com.Solo.LibraryManagement.domain.member.repository;

import com.Solo.LibraryManagement.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Page<Member> findAllByOrderByMemberIdDesc(Pageable pageable);
}
