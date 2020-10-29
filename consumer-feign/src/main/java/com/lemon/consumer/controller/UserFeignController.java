package com.lemon.consumer.controller;

import com.lemon.pojo.UserPO;
import com.lemon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:56
 **/
@RestController
public class UserFeignController {
    @Autowired
    private UserService service;
    @RequestMapping("/feign/add")
    public Boolean add(UserPO userPO) {
        return service.add(userPO);
    }
    @RequestMapping("/feign/getById")
    public UserPO getById(Integer id) {
        UserPO byId = service.getById11(id);
        System.out.println("123");
        return byId;
    }
    @RequestMapping("/feign/getAll")
    public List<UserPO> getAll() {
        return service.getAll();
    }
}
