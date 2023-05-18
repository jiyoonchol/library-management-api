package com.Solo.LibraryManagement.membership.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberShipPatchDto {
    private long membershipId;
    private boolean isActive;
    private boolean isOverdue;
}
