package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //추상화를 지키게 되었다.
    private final MemberRepository memberRepository;

    //MemoryMemberRepository에 무엇이 들어갈지를 생성자를 통해서 정한다.
    //생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
