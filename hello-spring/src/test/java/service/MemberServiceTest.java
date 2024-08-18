package service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @BeforeEach
    public void beforeEach(){ //외부에서 직접 넣어주기 ->같은 것 쓰기 윗줄,아랫줄(dependency injection)
       memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();

    }

    @Test
    void 회원가입() throws Exception {

        //given 뭔가 주어짐
        Member member = new Member();
        member.setName("hello");
        //when 이걸 검증함
        Long saveId = memberService.join(member);

        //then 이 데이터를 기반으로하는구나
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //후문이 실행될 때 IllegalStateException(예외처리)이 실행되어야 한다
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//
//        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//
//        memberService.join(member2);
    }
    @Test
    void findMembers() {

    }
}