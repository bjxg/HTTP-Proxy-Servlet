package me.bjxg.demo.http.proxy.config;

/**
 * @Description:
 * @Author: chengcy
 * @Date: 2022/5/21 03:38
 */
import me.bjxg.demo.http.proxy.interceptor.SignatureInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Bean
    public SignatureInterceptor getSignatureInterceptor(){
        return new SignatureInterceptor();
    }

    /**
     * 注册拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSignatureInterceptor())
                .addPathPatterns("/login")
                .addPathPatterns("/graphql");
    }
}
