package com.lemon.provider.controller;

import com.lemon.pojo.UserPO;
import com.lemon.provider.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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


    /**
     * 一下熔断的配置是指：
     * 在2秒内10次请求如果有50%的错误率，则将该服务熔断1秒（期间无论正确还是错误的请求都会走fallback）
     * 1秒后重新尝试是否成功
     * @param userPO
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启熔断 默认开启
        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "2000"), //统计的时间窗口，即多少秒内的失败率
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //单位时间的请求次数
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),  // 时间窗口内请求次数的失败率
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000") //当触发熔断后，服务熔断的时间
    })
    @RequestMapping(value = "/provider/user/add", method = RequestMethod.POST)
    public Boolean add(@RequestBody UserPO userPO) {
        return userService.add(userPO);
    }

    @RequestMapping(value = "/provider/user/getById", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getHystrix", commandProperties = {
            @HystrixProperty(name="", value = "1000")   //设置超时时间
    })
    public UserPO getById(Integer id) {
        UserPO byId = userService.getById(id);
        if(null == byId) {
            throw new RuntimeException("null is ");
        }
        return byId;
    }

    public UserPO getHystrix(Integer id) {
        return new UserPO().setId(0).setName("这是空的----@Hystrix");
    }


    @RequestMapping(value = "/provider/user/getAll", method = RequestMethod.GET)
    public List<UserPO> add() {
        return userService.getAll();
    }


}
