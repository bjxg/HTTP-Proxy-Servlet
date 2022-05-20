package me.bjxg.demo.http.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @Description:
 * @Author: chengcy
 * @Date: 2022/5/21 02:51
 */
@Slf4j
@RestController
public class TestController {
    @RequestMapping(value = "/api")
    public String test(@RequestBody String body, HttpServletRequest request){
        String auth = request.getHeader("auth");
        log.info(body);
        return "hello";
    }


}
