package life.majiang.community.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    SessionIntercepter sessionIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 那些地址拦截  excludePathPatterns 哪些 不要被拦截
        registry.addInterceptor(sessionIntercepter).addPathPatterns("/**");

    }
}

