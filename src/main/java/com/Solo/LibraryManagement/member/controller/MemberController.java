package com.Solo.LibraryManagement.member.controller;

import com.Solo.LibraryManagement.member.dto.MemberPatchDto;
import com.Solo.LibraryManagement.member.dto.MemberPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mc/member")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberPostDto memberPostDto) {
        return new ResponseEntity<>(memberPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);
        memberPatchDto.setMemberName("MemberName");
        memberPatchDto.setPhoneNumber("010-1234-5678");
        memberPatchDto.setMemberAddress("오사카");

        return new ResponseEntity<>(memberPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        System.out.println("# memberId: " + memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get members");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
