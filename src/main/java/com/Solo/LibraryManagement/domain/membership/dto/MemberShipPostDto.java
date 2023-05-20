package com.Solo.LibraryManagement.domain.membership.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberShipPostDto {
    private boolean isActive;
    private boolean isOverdue;
    // 가입 날짜
}
