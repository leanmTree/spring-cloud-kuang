package com.lemon.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author hengtao.wu
 * @Date 2020/10/30 9:49
 **/
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplicatiopn {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplicatiopn.class, args);
    }
}
