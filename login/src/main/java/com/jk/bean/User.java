package com.jk.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description: 骚骚的🐏
 * @Author: 杨
 * @Date: 2019/2/1 14:49
 */
@Data
public class User {
    private Integer id;       //id
    private Integer statea;
    private Integer RememberPswd;
    private String loginacct;     //用户名
    private String userpswd;     //用户名
    private String username;     //密码
    private String email;     //头像
    private String code;     //验证码
    private String userphone;     //手机号
    private String phone;       //黑名单phone字段
    private Integer hid;       //黑名单id
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;  //注册日期
    private String name;

}
