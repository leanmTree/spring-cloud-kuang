package com.lemon.eureka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 16:43
 **/
@SpringBootApplication
@EnableEurekaServer
public class Eureka7002Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7002Application.class, args);
    }
}
