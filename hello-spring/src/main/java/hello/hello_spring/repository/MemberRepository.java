package hello.hello_spring.repository;

import java.util.Optional;
import hello.hello_spring.domain.Member;
import java.util.List;

//회원 리포지토리 인터페이스
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
