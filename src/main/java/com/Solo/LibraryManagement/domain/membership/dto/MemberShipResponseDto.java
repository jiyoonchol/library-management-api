package com.Solo.LibraryManagement.domain.membership.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberShipResponseDto {
    private long membershipId;
    private boolean isActive;
    private boolean isOverdue;
}
