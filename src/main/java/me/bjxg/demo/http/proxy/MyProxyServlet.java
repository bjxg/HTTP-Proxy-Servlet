package me.bjxg.demo.http.proxy;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.mitre.dsmiley.httpproxy.ProxyServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: chengcy
 * @Date: 2022/5/21 02:38
 */
@Slf4j
public class MyProxyServlet extends ProxyServlet {
    @Override
    protected HttpResponse doExecute(HttpServletRequest servletRequest, HttpServletResponse servletResponse, HttpRequest proxyRequest) throws IOException {
        System.out.println(servletRequest.getAttribute("token"));
        // header 转换
        proxyRequest.setHeader("auth",(String) servletRequest.getAttribute("token"));

        return super.doExecute(servletRequest, servletResponse, proxyRequest);
    }
}
