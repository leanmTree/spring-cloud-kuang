package com.lemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:42
 **/
@SpringBootApplication
@EnableEurekaClient       //该注解也是提供服务注册于发现(该注解只能注册到eureka注册中心中)
@EnableDiscoveryClient    //该注解提供服务注解与发现（该注解可以注册到任何注册中心）
@EnableCircuitBreaker       //添加对hystrix的支持
public class Provider8004Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider8004Application.class, args);
    }
}
