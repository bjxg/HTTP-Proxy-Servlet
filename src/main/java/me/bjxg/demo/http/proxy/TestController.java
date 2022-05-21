package me.bjxg.demo.http.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: chengcy
 * @Date: 2022/5/21 02:51
 */
@Slf4j
@RestController
public class TestController {
    @RequestMapping(value = {"/login"})
    public String test(@RequestBody String body, HttpServletRequest request){
        String auth = request.getHeader("auth");
        log.info(body);
        return "hello";
    }


}
