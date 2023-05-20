package com.Solo.LibraryManagement.domain.membership.mapper;

import com.Solo.LibraryManagement.domain.membership.dto.MemberShipPatchDto;
import com.Solo.LibraryManagement.domain.membership.dto.MemberShipPostDto;
import com.Solo.LibraryManagement.domain.membership.dto.MemberShipResponseDto;
import com.Solo.LibraryManagement.domain.membership.entity.MemberShip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberShipMapper {
    MemberShip memberShipPostDtoToMemberShip(MemberShipPostDto memberShipPostDto);
    MemberShip memberShipPatchDtoToMemberShip(MemberShipPatchDto memberShipPatchDto);
    MemberShipResponseDto memberShipToMemberShipResponseDto(MemberShip memberShip);
}
