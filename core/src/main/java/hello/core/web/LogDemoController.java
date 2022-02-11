package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody //view 안거치고 문자를 그대로 보냄
    public String logDemo(HttpServletRequest request) { //고객 요청정보 받음
        String requestURL = request.getRequestURL().toString(); //고객이 어떤 url을 입력했는지 저장
        System.out.println("myLogger = "+myLogger.getClass());

        myLogger.setRequestURL(requestURL); //세팅
        myLogger.log("controller test"); //로그 출력
        logDemoService.logic("testId");
        return "OK";
    }
}
