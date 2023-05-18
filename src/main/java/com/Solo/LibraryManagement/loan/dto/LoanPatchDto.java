package com.Solo.LibraryManagement.loan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanPatchDto {
    private Long loanId;
    private boolean isOverdue;
    private boolean isReturned;
}
