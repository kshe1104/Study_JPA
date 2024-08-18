package service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service //바로 등록해줌
public class MemberService {


    private final MemberRepository memberRepository;//= new MemoryMemberRepository();

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     */

    public Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName()) //같은 이름이 있는 중복 회원X
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                }); //객체로 따로 받지 않고 바로실행

    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}