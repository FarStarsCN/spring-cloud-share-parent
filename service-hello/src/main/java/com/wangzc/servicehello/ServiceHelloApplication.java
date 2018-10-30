package com.wangzc.servicehello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * EnableEurekaClient：开启Eureka客户端。
 *
 * @author wang_zc
 * @date 2018/10/23
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHelloApplication.class, args);
    }
}
