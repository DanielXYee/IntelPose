package com.ifit.demo.mapper;

import com.ifit.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 17:15 2019/1/22
 * @Modified by:
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 通过id查找
     * @param id
     * @return
     */
    User findById(long id);

    /**
     * 新增
     * @param user
     * @return
     */
    Long insertUser(User user);

    /**
     * 通过账号查找
     * @param account
     * @return
     */
    User findByAccount(String account);
}
