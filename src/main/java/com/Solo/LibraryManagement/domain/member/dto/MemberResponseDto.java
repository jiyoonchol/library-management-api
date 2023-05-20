package com.Solo.LibraryManagement.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponseDto {
    private long memberId;
    private String memberName;
    private String phoneNumber;
    private String memberAddress;
}
