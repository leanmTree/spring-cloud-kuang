package com.lemon.provider.controller;

import com.lemon.pojo.UserPO;
import com.lemon.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:56
 **/
@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/provider/user/add", method = RequestMethod.POST)
    public Boolean add(@RequestBody UserPO userPO) {
        return userService.add(userPO);
    }

    @RequestMapping(value = "/provider/user/getById", method = RequestMethod.GET)
    public UserPO getById(Integer id) {
        System.out.println("");
        return userService.getById(id);
    }


    @RequestMapping(value = "/provider/user/getAll", method = RequestMethod.GET)
    public List<UserPO> add() {
        return userService.getAll();
    }


}
