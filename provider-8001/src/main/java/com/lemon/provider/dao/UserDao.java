package com.lemon.provider.dao;

import com.lemon.pojo.UserPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hengtao.wu
 * @Date 2020/10/22 14:31
 **/
@Mapper
public interface UserDao {

    boolean add(UserPO userPO);

    UserPO getById(Integer id);

    List<UserPO> getAll();
}
