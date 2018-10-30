package com.wangzc.servicehello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基于HTTP请求的服务
 *
 * @author wang_zc
 * @date 2018/10/19
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello " + name + ", I am from port:" + port;
    }
}
