package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    Member save(Member member);
    // Optional은 메소드를 사용한 반환값이 null인 경우 이것을 그대로 반환하지 않고 다르게 반환하기 위한 코드로 java8 부터 지원하는 기능이다.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
