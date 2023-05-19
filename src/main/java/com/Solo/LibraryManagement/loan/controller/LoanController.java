package com.Solo.LibraryManagement.loan.controller;

import com.Solo.LibraryManagement.loan.dto.LoanPatchDto;
import com.Solo.LibraryManagement.loan.dto.LoanPostDto;
import com.Solo.LibraryManagement.loan.entity.Loan;
import com.Solo.LibraryManagement.loan.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lc/loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    public ResponseEntity postLoan(@RequestBody LoanPostDto loanPostDto) {

        Loan loan = new Loan();
        loan.setOverdue(loanPostDto.isOverdue());
        loan.setReturned(loanPostDto.isReturned());
        return new ResponseEntity<>(loanPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{loan-id}")
    public ResponseEntity patchLoan(@PathVariable("loan-id") long loanId,
                                    @RequestBody LoanPatchDto loanPatchDto) {

        loanPatchDto.setLoanId(loanId);
        Loan loan = new Loan();
        loan.setLoanId(loanPatchDto.getLoanId());
        loan.setOverdue(loanPatchDto.isOverdue());
        loan.setOverdue(loanPatchDto.isReturned());
        Loan response = loanService.updateLoan(loan);
        return new ResponseEntity<>(loanPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{loan-id}")
    public ResponseEntity getLoan(@PathVariable("loan-id") long loanId) {

        System.out.println("# loanId: " + loanId);

        Loan response = loanService.findLoan(loanId);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getLoans() {

        List<Loan> response = loanService.findLoans();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{loan-id}")
    public ResponseEntity deleteLoans(@PathVariable("loan-id") long loanId) {

        System.out.println("# delete book");

        loanService.deleteLoan(loanId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
