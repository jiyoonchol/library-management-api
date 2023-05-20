package com.Solo.LibraryManagement.domain.loan.service;

import com.Solo.LibraryManagement.domain.loan.entity.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    public Loan createLoan(Loan loan) {
        Loan createdLoan = loan;
        return createdLoan;
    }

    public Loan updateLoan(Loan loan) {
        Loan updatedLoan = loan;
        return updatedLoan;
    }

    public Loan findLoan(long loanId) {
        Loan loan = new Loan(loanId, true, true, "2023");
        return loan;
    }

    public List<Loan> findLoans() {
        List<Loan> loans = List.of(
                new Loan(1L, true, true, "2023"),
                new Loan(2L, false, false, "2024"));
        return loans;
    }

    public void deleteLoan(long loanId) {

    }
}
