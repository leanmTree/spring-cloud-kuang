package com.lemon.service;

import com.lemon.pojo.UserPO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hengtao.wu
 * @Date 2020/10/23 15:47
 **/
@Component
@FeignClient(value = "provider", fallbackFactory = UserServiceFallbackFactory.class,fallback = UserServiceFallbackFactory.class)
public interface UserService {
    @PostMapping(value = "/provider/user/add")
    boolean add(@RequestBody UserPO userPO);
    @GetMapping(value = "/provider/user/getById")
    UserPO getById11(@RequestParam("id") Integer id);
    @GetMapping(value = "/provider/user/getAll")
    List<UserPO> getAll();
}
