package com.wangzc.servicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * EnableEurekaClient：表面是一个Eureka client
 * EnableFeignClients：通过Feign调用别的服务要使用此注解
 *
 * @author wang_zc
 * @date 2018/10/23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }
}
