package com.Solo.LibraryManagement.domain.loan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanPatchDto {
    private Long loanId;
    private boolean isOverdue;
    private boolean isReturned;
}
