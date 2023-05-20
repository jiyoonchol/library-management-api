package com.Solo.LibraryManagement.membership.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberShipResponseDto {
    private long membershipId;
    private boolean isActive;
    private boolean isOverdue;
}
