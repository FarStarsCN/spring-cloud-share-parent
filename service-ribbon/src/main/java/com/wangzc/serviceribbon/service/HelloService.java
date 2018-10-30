package com.wangzc.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wang_zc
 * @date 2018/10/24
 */
@Service
public class HelloService {

    private final RestTemplate restTemplate;

    @Autowired
    public HelloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "error")
    public String sayHello(String name) {
        return restTemplate.getForObject("http://SERVICE-HELLO/hello?name=" + name, String.class);
    }

    public String error(String name) {
        return "sorry " + name + ", I have an error!";
    }
}
