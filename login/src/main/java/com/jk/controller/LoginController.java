package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.LoginService;
import com.jk.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 骚骚的🐏
 * @Author: 杨
 * @Date: 2019/2/1 14:21
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;
    //登录
    @RequestMapping("queryUserByNameAndPswd")
    public User queryUserByNameAndPswd(@RequestBody User user){

        return loginService.queryUserByNameAndPswd(user);
    }
    //手机号验重
    @RequestMapping("existsPhone")
    public  User existsPhone(@RequestBody String phone_number){

        return loginService.existsPhone(phone_number);
    }
    //黑名单
    @RequestMapping("heiPhone")
    public User heiPhone(@RequestBody String phone_number){

        return loginService.heiPhone(phone_number);
    }
    //用户验重
    @RequestMapping("queryByName")
    public User queryByName(@RequestBody String loginacct){

        return loginService.queryByName(loginacct);
    }
    //注册
    @RequestMapping("register")
    public void  register(@RequestBody User user){

       String chunzai= loginService.register( user);
        System.out.println("register返回值======>"+chunzai);
    }

}
