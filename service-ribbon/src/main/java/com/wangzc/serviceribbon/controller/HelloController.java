package com.wangzc.serviceribbon.controller;

import com.wangzc.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wang_zc
 * @date 2018/10/24
 */
@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/ribbon")
    public String hello(@RequestParam("name") String name) {
        return helloService.sayHello(name);
    }
}
