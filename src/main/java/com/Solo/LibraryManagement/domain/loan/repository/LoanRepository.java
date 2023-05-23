package com.Solo.LibraryManagement.domain.loan.repository;

import com.Solo.LibraryManagement.domain.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
