package com.Solo.LibraryManagement.domain.loan.controller;

import com.Solo.LibraryManagement.domain.loan.dto.LoanPatchDto;
import com.Solo.LibraryManagement.domain.loan.dto.LoanPostDto;
import com.Solo.LibraryManagement.domain.loan.dto.LoanResponseDto;
import com.Solo.LibraryManagement.domain.loan.entity.Loan;
import com.Solo.LibraryManagement.domain.loan.mapper.LoanMapper;
import com.Solo.LibraryManagement.domain.loan.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lc/loan")
public class LoanController {

    private final LoanService loanService;
    private final LoanMapper loanMapper;

    public LoanController(LoanService loanService, LoanMapper loanMapper) {
        this.loanService = loanService;
        this.loanMapper = loanMapper;
    }

    public ResponseEntity postLoan(@RequestBody LoanPostDto loanPostDto) {

        Loan loan = loanMapper.loanPostDtoToLoan(loanPostDto);
        Loan response = loanService.createLoan(loan);
        return new ResponseEntity<>(loanMapper.loanToLoanResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{loan-id}")
    public ResponseEntity patchLoan(@PathVariable("loan-id") @Positive long loanId,
                                    @RequestBody LoanPatchDto loanPatchDto) {

        loanPatchDto.setLoanId(loanId);

        Loan response = loanService.updateLoan(loanMapper.loanPatchDtoToLoan(loanPatchDto));
        return new ResponseEntity<>(loanMapper.loanToLoanResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{loan-id}")
    public ResponseEntity getLoan(@PathVariable("loan-id") @Positive long loanId) {


        Loan response = loanService.findLoan(loanId);


        return new ResponseEntity<>(loanMapper.loanToLoanResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getLoans() {


        List<Loan> loans = loanService.findLoans();
        List<LoanResponseDto> response =
        loans.stream()
                .map(loan -> loanMapper.loanToLoanResponseDto(loan))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{loan-id}")
    public ResponseEntity deleteLoans(@PathVariable("loan-id") @Positive long loanId) {

        System.out.println("# delete book");

        loanService.deleteLoan(loanId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
