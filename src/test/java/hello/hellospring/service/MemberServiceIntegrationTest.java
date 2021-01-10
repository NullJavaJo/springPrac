package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    //Test 클래스를 만들고 싶은 클래스의 이름을 클릭한 상태에서 Ctrl + shift + t를 누르면 Create Test class라는 버튼이
    // 나온다. 그리고 클래스를 만들때 나오는 팝업에서 만들고싶은 테스트 메소드들을 클릭을하고 생성을 하면 자동으로
    // test 패키지 아래 원래 클래스의 패키지 구조와 같게 test 클래스가 만들어 진다.


    // Test 클래스의 경우 외국인과 같이 일하는 경우가 아니면 한글로 직관적으로 적어줄 수 있다.
    // Test 클래스가 build 될때 테스트 코드는 실제 코드에 포함되지 않는다.

//    MemberService memberService = new MemberService(memberRepository);
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

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

        org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then
    }

}