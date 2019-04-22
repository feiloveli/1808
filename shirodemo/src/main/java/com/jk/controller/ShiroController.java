package com.jk.controller;

import com.jk.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ShiroController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/errorlogin")
    public String errorlogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*获取到登录失败的异常信息
        String shiroLoginFailure = (String)request.getAttribute("loginException");
        Map<String, String> map = new HashMap<>();
        if(UnknownAccountException.class.getName().equals(shiroLoginFailure))
        {
            map.put("message","用户名错误");
        }else if(IncorrectCredentialsException.class.getName().equals(shiroLoginFailure)){
            map.put("message","密码错误");
        }else{
            //如果是未知异常 跳转到登录页面
            response.sendRedirect("/login");
        }*/
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }



    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("username:"+username+",password:"+password);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //主体
        Subject subject = SecurityUtils.getSubject();


        //主体进行登陆
        subject.login(token);
        return "index";
    }



}
