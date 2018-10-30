package com.wangzc.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * EnableHystrix：开启断路器
 *
 * @author wang_zc
 * @date 2018/10/24
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    /**
     * 向ioc容器注入RestTemplate
     * LoadBalanced：开启负载均衡
     *
     * @author wang_zc
     * @return org.springframework.web.client.RestTemplate
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
