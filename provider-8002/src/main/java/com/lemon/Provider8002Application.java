package com.lemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:42
 **/
@SpringBootApplication
@EnableEurekaClient
public class Provider8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider8002Application.class, args);
    }
}
