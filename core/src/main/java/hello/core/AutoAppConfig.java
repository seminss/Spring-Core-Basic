package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        //설정정보를 컴포넌트스캔 대상에서 제외
        excludeFilters = @Filter(type= FilterType.ANNOTATION, classes=Configuration.class)
)
public class AutoAppConfig {
    //수동 빈 등록시 자동 빈 등록된 것과 이름이 같으면 충돌
/*  @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }*/
}
