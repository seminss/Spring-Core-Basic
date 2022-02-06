package hello.core;

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

}
