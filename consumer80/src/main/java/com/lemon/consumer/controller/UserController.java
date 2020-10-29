package com.lemon.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.lemon.pojo.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:56
 **/
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;


//    private static final String URL_PREFIX="http://localhost:8001/";
    private static final String URL_PREFIX="http://provider/";


    @RequestMapping("/add")
    public Boolean add(UserPO userPO) {
        return restTemplate.postForObject(URL_PREFIX + "provider/user/add", userPO, Boolean.class);
    }
    @RequestMapping("/getById")
    public UserPO getById(Integer id) {
        return restTemplate.getForObject(URL_PREFIX + "provider/user/getById?id=" +id, UserPO.class);
    }

    @RequestMapping("/getAll")
    public List<UserPO> getAll() {
        return restTemplate.getForObject(URL_PREFIX + "provider/user/getAll", List.class);
    }

}
