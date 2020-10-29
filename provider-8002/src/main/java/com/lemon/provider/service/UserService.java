package com.lemon.provider.service;

import com.lemon.pojo.UserPO;

import java.util.List;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:39
 **/
public interface UserService {

    boolean add(UserPO userPO);

    UserPO getById(Integer id);

    List<UserPO> getAll();
}
