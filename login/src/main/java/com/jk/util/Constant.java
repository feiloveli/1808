/** 
 * <pre>项目名称:ssm 
 * 文件名称:Constant.java 
 * 包名:com.jk.util 
 * 创建日期:2018年12月20日下午7:03:22 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.util;

/** 
 * <pre>项目名称：ssm    
 * 类名称：Constant    
 * 类描述：    
 * 创建人：杨彦斌  
 * 创建时间：2018年12月20日 下午7:03:22    
 * 修改人：杨彦斌 
 * 修改时间：2018年12月20日 下午7:03:22    
 * 修改备注：       
 * @version </pre>   
 * 
 *  给系统提供一些常量的类 
 */
public class Constant { //redis key
	/**
	 * 用来   存到redis的缓存 树
	 */
	/*用来   存到redis的缓存 树*/
	public static final String left_tree="left_tree_";
	/*用来   存到redis的缓存 验证码*/
	/**
	 * 用来   存到redis的缓存 验证码
	 */
	public static final String verification_code="verification_code_";
	//判断手机号是不是多次获取验证码(redis 保存的验证码)
	public static final String multiple_code = "multiple_code_"; 

}
