/** 
 * <pre>项目名称:power 
 * 文件名称:Result.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018年12月14日下午1:47:48 
 * Copyright (c) 2018, wzstart@126.com All Rights Reserved.</pre> 
 */
package com.jk.util;

import java.util.List;

import lombok.Data;

/**
 * 业精于勤荒于嬉,行成于思毁于随 创建人：wzstart 创建时间：2018年12月14日 下午1:47:48
 */
@Data
public class Result {

	//返回给前台的状态码
	private Integer code;
	private Integer exists_phone;
	private Integer HeMingDan_phone;

	private String msg;

	private Object data;

	private boolean state = true;
	
	
	
}
