package com.Solo.LibraryManagement.membership.mapper;

import com.Solo.LibraryManagement.membership.dto.MemberShipPatchDto;
import com.Solo.LibraryManagement.membership.dto.MemberShipPostDto;
import com.Solo.LibraryManagement.membership.dto.MemberShipResponseDto;
import com.Solo.LibraryManagement.membership.entity.MemberShip;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberShipMapper {
    MemberShip memberShipPostDtoToMemberShip(MemberShipPostDto memberShipPostDto);
    MemberShip memberShipPatchDtoToMemberShip(MemberShipPatchDto memberShipPatchDto);
    MemberShipResponseDto memberShipToMemberShipResponseDto(MemberShip memberShip);
}
