package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/member/new")
    public String newMemberForm(){
        return "member/new";
    }

    @PostMapping("/join")
    public String createMember(MemberForm memberForm){
        Member member = memberForm.toEntity();
        memberRepository.save(member);
        return "";
    }
}
