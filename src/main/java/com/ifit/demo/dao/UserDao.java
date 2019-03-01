package com.ifit.demo.dao;

import com.ifit.demo.entity.User;
import com.ifit.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 19:02 2019/1/22
 * @Modified by:
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public User getById(long id){
        return userMapper.findById(id);
    }

    public User getByAccount(String account){
        return userMapper.findByAccount(account);
    }
}
