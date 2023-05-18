package com.Solo.LibraryManagement.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberPatchDto {
    private long memberId;
    private String memberName;
    private String phoneNumber;
    private String memberAddress;
}