package com.lemon.provider.service;

import com.lemon.pojo.UserPO;
import com.lemon.provider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:40
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public boolean add(UserPO userPO) {
        return userDao.add(userPO);
    }

    public UserPO getById(Integer id) {
        return userDao.getById(id);
    }

    public List<UserPO> getAll() {
        return userDao.getAll();
    }
}
