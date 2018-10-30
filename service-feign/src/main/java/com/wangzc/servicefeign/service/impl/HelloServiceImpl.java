package com.wangzc.servicefeign.service.impl;

import com.wangzc.servicefeign.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author wang_zc
 * @date 2018/10/19
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "sorry " + name + ", I have an error!";
    }
}
