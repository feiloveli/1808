/** 
 * <pre>项目名称:power 
 * 文件名称:QueryParam.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018年12月14日上午11:05:40 
 * Copyright (c) 2018, wzstart@126.com All Rights Reserved.</pre> 
 */
package com.jk.util;

import java.util.List;

import lombok.Data;

/**
 * 用来接收前台的参数
 */
@Data
public class QueryParam {

	private Integer userid;
	
	private List<Integer> roid;

	private Integer roleid; //角色id
	
	private List<Integer> powerId;// 接收权限id
	
	private String verification_code;//用户输入的验证码
	/**发送验证码的手机号*/
	private String phone_number;//发送验证码的手机号
	
	private String com;
	private String no;
	private String key;

	
}
