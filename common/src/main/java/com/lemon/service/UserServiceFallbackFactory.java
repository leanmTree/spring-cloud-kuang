package com.lemon.service;

import com.lemon.pojo.UserPO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hengtao.wu
 * @Date 2020/10/29 14:45
 **/
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {

    public UserService create(Throwable throwable) {
        return new UserService() {
            public boolean add(UserPO userPO) {
                return false;
            }

            public UserPO getById11(Integer id) {
                return new UserPO().setId(0).setName("provider服务已经停止运行，这是在common降级后的实现类提供的返回");
            }

            public List<UserPO> getAll() {
                return null;
            }
        };
    }
}
