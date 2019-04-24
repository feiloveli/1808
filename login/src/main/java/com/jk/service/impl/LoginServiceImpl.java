package com.jk.service.impl;

import com.jk.bean.User;
import com.jk.mapper.LoginMapper;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description: 骚骚的🐏
 * @Author: 杨
 * @Date: 2019/2/1 14:22
 */
@Service
public class LoginServiceImpl implements LoginService {

   @Autowired
    LoginMapper loginMapper;


    //查询此手机号有没有注册
    @Override
    public User existsPhone(String phone_number) {
        User user= loginMapper.existsPhone(phone_number);
        return user;
    }
   //查询黑名单有没有此手机号
    @Override
    public User heiPhone(String phone_number) {
        User user= loginMapper.heiPhone(phone_number);

        return user;
    }


   //登录
    public User queryUserByNameAndPswd(User user) {
        User user2 = loginMapper.queryUserByNameAndPswd(user);

       return user2;
    }
  //用户验重
    @Override
    public User queryByName(String loginacct) {
        User user2 = loginMapper.queryByName(loginacct);
        return user2;
    }
  //注册
    @Override
    public String register(User user) {
        try {
            loginMapper.register(user);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "2";
        }
    }


}
