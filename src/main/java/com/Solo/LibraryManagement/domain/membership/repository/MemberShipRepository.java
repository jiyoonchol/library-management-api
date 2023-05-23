package com.Solo.LibraryManagement.domain.membership.repository;

import com.Solo.LibraryManagement.domain.membership.entity.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberShipRepository extends JpaRepository<MemberShip, Long> {
}
