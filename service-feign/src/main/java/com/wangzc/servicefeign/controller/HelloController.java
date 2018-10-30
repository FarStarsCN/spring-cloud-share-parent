package com.wangzc.servicefeign.controller;

import com.wangzc.servicefeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wang_zc
 * @date 2018/10/19
 */
@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(value = "/feign")
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
