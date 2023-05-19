package com.Solo.LibraryManagement.member.controller;

import com.Solo.LibraryManagement.member.dto.MemberPatchDto;
import com.Solo.LibraryManagement.member.dto.MemberPostDto;
import com.Solo.LibraryManagement.member.entity.Member;
import com.Solo.LibraryManagement.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mc/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {

        Member member = new Member();
        member.setMemberName(memberPostDto.getMemberName());
        member.setPhoneNumber(member.getPhoneNumber());
        member.setMemberAddress(member.getMemberAddress());
        Member response = memberService.createMember(member);
        return new ResponseEntity<>(memberPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);
        Member member = new Member();
        memberPatchDto.setMemberName("MemberName");
        memberPatchDto.setPhoneNumber("010-1234-5678");
        memberPatchDto.setMemberAddress("오사카");

        Member response = memberService.updateMember(member);

        return new ResponseEntity<>(memberPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {

        System.out.println("# memberId: " + memberId);

        Member response = memberService.findMember(memberId);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {


        List<Member> response = memberService.findMembers();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId) {
        System.out.println("# delete member");

        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
