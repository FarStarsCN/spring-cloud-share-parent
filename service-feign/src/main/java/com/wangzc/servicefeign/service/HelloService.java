package com.wangzc.servicefeign.service;

import com.wangzc.servicefeign.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient：表示要调用的服务，就是配置文件里面注册的名称
 *
 * @author wang_zc
 * @date 2018/10/19
 */
@FeignClient(value = "service-hello", fallback = HelloServiceImpl.class)
public interface HelloService {

    @RequestMapping("/hello")
    String sayHello(@RequestParam(value = "name") String name);

}