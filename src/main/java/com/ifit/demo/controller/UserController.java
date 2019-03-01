package com.ifit.demo.controller;

import com.ifit.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 17:33 2019/1/22
 * @Modified by:
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Description: 简易登录
     * @Author: WinstonDeng
     * @Date: 9:11 2019/1/23
     */
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Long> login(@RequestBody Map<String,String> loginInfo){
        //TODO 待修正为结合jwt的登录
        String account="account";
        String password="password";
        return ResponseEntity.ok().body(userService.login(loginInfo.get(account),loginInfo.get(password)));
    }
}
