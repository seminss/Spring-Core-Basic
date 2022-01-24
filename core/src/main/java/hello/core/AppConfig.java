package hello.core;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {
    //MemberServiceImpl을 만들고, 내가 만든 MemberServiceImpl은 MemoryMemberRepository를 사용할거야
    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }

    //MemoryMemberRepository와 FixDiscountPolicy를 넣고 계산한 객체를 반환한다.
    public OrderService orderService(){
        return new OrderServiceImpl(
            memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
