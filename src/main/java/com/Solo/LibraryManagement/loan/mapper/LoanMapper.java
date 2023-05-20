package com.Solo.LibraryManagement.loan.mapper;

import com.Solo.LibraryManagement.loan.dto.LoanPatchDto;
import com.Solo.LibraryManagement.loan.dto.LoanPostDto;
import com.Solo.LibraryManagement.loan.dto.LoanResponseDto;
import com.Solo.LibraryManagement.loan.entity.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    Loan loanPostDtoToLoan(LoanPostDto loanPostDto);

    Loan loanPatchDtoToLoan(LoanPatchDto loanPatchDto);

    LoanResponseDto loanToLoanResponseDto(Loan loan);
}
