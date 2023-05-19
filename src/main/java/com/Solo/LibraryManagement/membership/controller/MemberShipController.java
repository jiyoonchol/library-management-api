package com.Solo.LibraryManagement.membership.controller;

import com.Solo.LibraryManagement.membership.dto.MemberShipPatchDto;
import com.Solo.LibraryManagement.membership.dto.MemberShipPostDto;
import com.Solo.LibraryManagement.membership.entity.MemberShip;
import com.Solo.LibraryManagement.membership.service.MemberShipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msc/membership")
public class MemberShipController {
    private final MemberShipService memberShipService;

    public MemberShipController(MemberShipService memberShipService) {
        this.memberShipService = memberShipService;
    }

    @PostMapping
    public ResponseEntity postMemberShip(@RequestBody MemberShipPostDto memberShipPostDto) {
        MemberShip memberShip = new MemberShip();
        memberShip.setActive(memberShipPostDto.isActive());
        memberShip.setOverDue(memberShipPostDto.isOverdue());
        MemberShip response = memberShipService.createMemberShip(memberShip);
        return new ResponseEntity<>(memberShipPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{membership-id}")
    public ResponseEntity patchMemberShip(@PathVariable("membership-id") long membershipId,
                                          @RequestBody MemberShipPatchDto memberShipPatchDto) {

        memberShipPatchDto.setMembershipId(membershipId);
        MemberShip memberShip = new MemberShip();
        memberShipPatchDto.setActive(true);
        memberShipPatchDto.setOverdue(true);

        MemberShip response = memberShipService.updateMemberShip(memberShip);

        return new ResponseEntity<>(memberShipPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{membership-id}")
    public ResponseEntity getMemberShip(@PathVariable("membership-id") long membershipId) {
        System.out.println("# membershipId: " + membershipId);

        MemberShip response = memberShipService.findMemberShip(membershipId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMemberShips() {

        List<MemberShip> response = memberShipService.findMemberShips();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{membership-id}")
    public ResponseEntity deleteMemberShip(@PathVariable("membership-id") long membershipId) {
        System.out.println("# delete memberShip");

        memberShipService.deleteMemberShip(membershipId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}