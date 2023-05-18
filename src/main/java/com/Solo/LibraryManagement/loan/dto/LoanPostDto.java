package com.Solo.LibraryManagement.loan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanPostDto {
    private boolean isOverdue;
    private boolean isReturned;
    // 대출 시작일, 반납 예정일, 반납 시간 추가
}