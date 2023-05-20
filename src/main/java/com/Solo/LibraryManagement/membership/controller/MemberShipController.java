package com.Solo.LibraryManagement.membership.controller;

import com.Solo.LibraryManagement.membership.dto.MemberShipPatchDto;
import com.Solo.LibraryManagement.membership.dto.MemberShipPostDto;
import com.Solo.LibraryManagement.membership.dto.MemberShipResponseDto;
import com.Solo.LibraryManagement.membership.entity.MemberShip;
import com.Solo.LibraryManagement.membership.mapper.MemberShipMapper;
import com.Solo.LibraryManagement.membership.service.MemberShipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/msc/membership")
public class MemberShipController {
    private final MemberShipService memberShipService;
    private final MemberShipMapper memberShipMapper;

    public MemberShipController(MemberShipService memberShipService, MemberShipMapper memberShipMapper) {
        this.memberShipService = memberShipService;
        this.memberShipMapper = memberShipMapper;
    }

    @PostMapping
    public ResponseEntity postMemberShip(@RequestBody MemberShipPostDto memberShipPostDto) {
        MemberShip memberShip = memberShipMapper.memberShipPostDtoToMemberShip(memberShipPostDto);

        MemberShip response = memberShipService.createMemberShip(memberShip);
        return new ResponseEntity<>(memberShipMapper.memberShipToMemberShipResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{membership-id}")
    public ResponseEntity patchMemberShip(@PathVariable("membership-id") @Positive long membershipId,
                                          @RequestBody MemberShipPatchDto memberShipPatchDto) {

        memberShipPatchDto.setMembershipId(membershipId);


        MemberShip response = memberShipService.updateMemberShip(memberShipMapper.memberShipPatchDtoToMemberShip(memberShipPatchDto));

        return new ResponseEntity<>(memberShipMapper.memberShipToMemberShipResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{membership-id}")
    public ResponseEntity getMemberShip(@PathVariable("membership-id") @Positive long membershipId) {

        MemberShip response = memberShipService.findMemberShip(membershipId);

        return new ResponseEntity<>(memberShipMapper.memberShipToMemberShipResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMemberShips() {

        List<MemberShip> memberShips = memberShipService.findMemberShips();
        List<MemberShipResponseDto> response =
                memberShips.stream()
                        .map(memberShip -> memberShipMapper.memberShipToMemberShipResponseDto(memberShip))
                        .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{membership-id}")
    public ResponseEntity deleteMemberShip(@PathVariable("membership-id") @Positive long membershipId) {
        System.out.println("# delete memberShip");

        memberShipService.deleteMemberShip(membershipId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}