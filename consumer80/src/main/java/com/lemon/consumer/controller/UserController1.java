package com.lemon.consumer.controller;

import com.lemon.pojo.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:56
 **/
@RestController
public class UserController1 {

    @RequestMapping("/consumer/hello")
    public String hello(UserPO userPO) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return "this OK";
    }

}
