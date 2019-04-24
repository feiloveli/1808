package com.jk.mapper;

import com.jk.bean.User;

/**
 * @Description: 骚骚的🐏
 * @Author: 杨
 * @Date: 2019/2/1 14:22
 */
public interface LoginMapper {


     User queryUserByNameAndPswd(User user);

     User existsPhone(String phone_number);

     User heiPhone(String phone_number);

    User queryByName(String loginacct);

    void register(User user);
}
