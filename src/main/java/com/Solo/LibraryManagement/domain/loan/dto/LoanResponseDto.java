package com.Solo.LibraryManagement.domain.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoanResponseDto {
    private Long loanId;
    private boolean isOverdue;
    private boolean isReturned;
}
