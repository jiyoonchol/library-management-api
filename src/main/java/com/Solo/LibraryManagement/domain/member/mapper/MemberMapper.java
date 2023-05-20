package com.Solo.LibraryManagement.domain.member.mapper;

import com.Solo.LibraryManagement.domain.member.dto.MemberResponseDto;
import com.Solo.LibraryManagement.domain.member.dto.MemberPatchDto;
import com.Solo.LibraryManagement.domain.member.dto.MemberPostDto;
import com.Solo.LibraryManagement.domain.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);

}
