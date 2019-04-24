package com.jk.service;

import com.jk.bean.User;

/**
 * @Description: 骚骚的🐏
 * @Author: 杨
 * @Date: 2019/2/1 14:21
 */
public interface LoginService {

    User existsPhone(String phone_number);

    User heiPhone(String phone_number);

    User queryUserByNameAndPswd(User user);

    User queryByName(String loginacct);

    String register(User user);
}
