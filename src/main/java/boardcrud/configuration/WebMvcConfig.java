package boardcrud.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry regist){
        // TODO 기능 추가시 할 예정
    }
}
