package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) { //기대하는 공통 포멧: [UUID][requestURL] {message}
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " +
                message); //세팅된 값 출력
    }

    @PostConstruct //생성 시점에 실행 ->uuid init
    public void init() {
        uuid = UUID.randomUUID().toString(); //고유한 UUID 생성 -> HTTP 요청구분
        System.out.println("[" + uuid + "] request scope bean create:" + this); //초기화 했어요~
    }

    @PreDestroy //종료 시점에 실행
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}