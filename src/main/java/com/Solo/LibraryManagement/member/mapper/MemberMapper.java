package com.Solo.LibraryManagement.member.mapper;

import com.Solo.LibraryManagement.member.dto.MemberPatchDto;
import com.Solo.LibraryManagement.member.dto.MemberPostDto;
import com.Solo.LibraryManagement.member.dto.MemberResponseDto;
import com.Solo.LibraryManagement.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);

}
