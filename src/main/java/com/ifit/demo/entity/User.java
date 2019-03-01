package com.ifit.demo.entity;

/**
 * @Author: WinstonDeng
 * @Description: 用户
 * @Date: Created in 17:02 2019/1/22
 * @Modified by:
 */
public class User {
    private long id;
    private String account;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
