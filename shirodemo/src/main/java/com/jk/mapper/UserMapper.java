package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User findByUsername(@Param("username") String username);
}
