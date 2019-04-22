package com.jk.shiro;


import com.jk.model.Permission;
import com.jk.model.Role;
import com.jk.model.User;
import com.jk.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //认证   AuthenticationToken 用于收集用户提交的身份（如用户名）及凭据（如密码）
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //用户名/密码的认证机制 UsernamePasswordToken实现了俩个接口
        // 第一个实现的是HostAuthenticationToken 主机验证
        //第二个RememberMeAuthenticationToken 通过令牌设置记住我的功能
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //从转换后的token中获取用户名的信息
        String username = usernamePasswordToken.getUsername();
        //获取用户的密码
        User user = userService.findByUsername(username);
        //如果查询用户对象为空则证明 无此用户名
        if(user == null){
            //若用户名不存在 则抛出未知用户名异常
            throw new UnknownAccountException();
        }
        //SimpleAuthenticationInfo 认证器  第一个参数为用户名
        //第二个字段是user.getPassword()，注意这里是指从数据库中获取的password
        //第三个字段是realm，即当前realm的名称
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
        return simpleAuthenticationInfo;
    }
    //权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        //User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        //session中获取用户
        User user  = (User)principalCollection.getPrimaryPrincipal();
        //第三种 从session获取用户的方法
        //SecurityUtils.getSubject().getPrincipal();
        //权限关键字写法
        String username = user.getUsername();
        //权限集合
        List<String> permissionList = new ArrayList<>();
        permissionList.add("user:add");
        //permissionList.add("user:delete");
        permissionList.add("log:edit");
        permissionList.add("log:query");
        //角色集合
        //List<String> roleNameList = new ArrayList<>();
        //Set<Role> roleSet =  user.getRoles();


        /*if(CollectionUtils.isNotEmpty(roleSet)){
            for(Role role : roleSet){
                roleNameList.add(role.getRname());
                Set<Permission> permissionSet = role.getPermissons();
                if(CollectionUtils.isNotEmpty(permissionSet)){
                    for(Permission permission : permissionSet){
                        //放入权限集合
                        permissionList.add(permission.getName());
                    }
                }
            }
        }*/
        //授权器
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //把权限放入授权器中
        info.addStringPermissions(permissionList);
        return info;
    }
}
