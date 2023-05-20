package com.Solo.LibraryManagement.domain.membership.service;

import com.Solo.LibraryManagement.domain.membership.entity.MemberShip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberShipService {
    public MemberShip createMemberShip(MemberShip memberShip) {
        MemberShip createdMemberShip = memberShip;
        return createdMemberShip;
    }

    public MemberShip updateMemberShip(MemberShip memberShip) {
        MemberShip updatedMemberShip = memberShip;
        return updatedMemberShip;
    }

    public MemberShip findMemberShip(long memberShipId) {
        MemberShip memberShip = new MemberShip(memberShipId, true, true);
        return memberShip;
    }

    public List<MemberShip> findMemberShips() {
        List<MemberShip> memberShips = List.of(
                new MemberShip(1L, true, true),
                new MemberShip(2L, false, false));
        return memberShips;
    }

    public void deleteMemberShip(long memberShipId) {

    }
}
