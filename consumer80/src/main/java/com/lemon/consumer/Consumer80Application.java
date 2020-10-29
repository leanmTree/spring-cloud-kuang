package com.lemon.consumer;

import com.lemon.consumer.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:57
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "provider", configuration = MyRule.class)
public class Consumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer80Application.class, args);
    }
}
