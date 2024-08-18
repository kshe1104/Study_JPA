package hello.hello_spring.controller;


import hello.hello_spring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.MemberService;

@Controller
public class MemberController {
//    private final MemberService memberService = new MemberService(); //문제가 생김 ->여러군데 문제 생김
    private final MemberService memberService;

@Autowired
    public MemberController(MemberService memberService){
    this.memberService = memberService;
}
}
