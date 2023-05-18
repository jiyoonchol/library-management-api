package com.Solo.LibraryManagement.membership.controller;

import com.Solo.LibraryManagement.membership.dto.MemberShipPatchDto;
import com.Solo.LibraryManagement.membership.dto.MemberShipPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msc/membership")
public class MemberShipController {
    @PostMapping
    public ResponseEntity postMemberShip(@RequestBody MemberShipPostDto memberShipPostDto) {
        return new ResponseEntity<>(memberShipPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{membership-id}")
    public ResponseEntity patchMemberShip(@PathVariable("membership-id") long membershipId,
                                          @RequestBody MemberShipPatchDto memberShipPatchDto) {

        memberShipPatchDto.setMembershipId(membershipId);
        memberShipPatchDto.setActive(true);
        memberShipPatchDto.setOverdue(true);

        return new ResponseEntity<>(memberShipPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{membership-id}")
    public ResponseEntity getMemberShip(@PathVariable("membership-id") long membershipId) {
        System.out.println("# membershipId: " + membershipId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMemberShips() {
        System.out.println("# MemberShips");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{membership-id}")
    public ResponseEntity deleteMemberShip(@PathVariable("membership-id") long membershipId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}