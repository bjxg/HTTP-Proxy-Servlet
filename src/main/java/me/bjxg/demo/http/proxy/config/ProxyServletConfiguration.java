package me.bjxg.demo.http.proxy.config;

import me.bjxg.demo.http.proxy.MyProxyServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: chengcy
 * @Date: 2022/5/21 02:36
 */
@Configuration
public class ProxyServletConfiguration {
    /**
     * 读取配置文件中路由设置
     */
    @Value("${proxy.servlet_url}")
    private String servlet_url;
    /**
     * 读取配置中代理目标地址
     */
    @Value("${proxy.target_url}")
    private String target_url;

    @Bean
    public Servlet createProxyServlet() {
        /** 创建新的ProxyServlet */
        return new MyProxyServlet();
    }

    @Bean
    public ServletRegistrationBean proxyServletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(createProxyServlet(), servlet_url);
        //设置网址以及参数
        Map<String, String> params = new HashMap<>();
        params.put("targetUri", target_url);
        params.put( "log", "true");
        registrationBean.setInitParameters(params);
        return registrationBean;
    }
}
