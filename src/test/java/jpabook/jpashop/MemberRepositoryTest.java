//package jpabook.jpashop;
//
//import jpabook.jpashop.domain.Member;
//import jpabook.jpashop.repository.MemberRepository;
//import jpabook.jpashop.service.MemberService;
//import jpabook.jpashop.repository.MemberRepositoryOld;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//@SpringBootTest
//@Transactional
//class MemberRepositoryTest {
//
//    @Autowired
//    MemberService memberService;
//    @Autowired
//    MemberRepository memberRepository;
//    @Autowired
//    EntityManager em;
//
//    @Test
//    void 회원가입() throws Exception {
//        //given
//        final Member member = new Member();
//        member.setName("lee");
//        //when
//        final Long savedId = memberService.join(member);
//        //then
//        assertEquals(member, memberRepository.findById(savedId));
//    }
//
//    @Test
//    void 중복_회원_예외() throws Exception {
//        //given
//        final Member member1 = new Member();
//        member1.setName("lee");
//
//        final Member member2 = new Member();
//        member2.setName("lee");
//        //when
//        memberService.join(member1);
//
//        //then
//        Assertions.assertThrows(IllegalStateException.class, () -> {
//            memberService.join(member2);
//        });
//    }
//
//}