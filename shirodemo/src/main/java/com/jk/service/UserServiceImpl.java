package com.jk.service;


import com.jk.mapper.UserMapper;
import com.jk.model.User;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {

        return userMapper.findByUsername(username);
    }
}
