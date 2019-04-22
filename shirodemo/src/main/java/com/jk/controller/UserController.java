package com.jk.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("addUser")
    //Requires 必须的  Permissions 权限
    @RequiresPermissions("user:add")
    public void addUser(){
        System.out.println("成功调到新增用户请求");
    }

    @RequestMapping("deleteUser")
    @RequiresPermissions("user:delete")
    public void deleteUser(){
        System.out.println("成功进入删除用户请求");
    }
}
