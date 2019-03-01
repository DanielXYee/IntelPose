package com.ifit.demo.service;

import com.ifit.demo.dao.UserDao;
import com.ifit.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 19:01 2019/1/22
 * @Modified by:
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Long login(String account,String password){
        User user=userDao.getByAccount(account);
        if(password.equals(user.getPassword())){
            return user.getId();
        }else {
            return null;
        }
    }
}
