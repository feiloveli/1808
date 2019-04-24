/** 
 * <pre>项目名称:ssm-task-zhangs 
 * 文件名称:Log.java 
 * 包名:com.jk.pojo 
 * 创建日期:2019年1月6日下午2:48:47 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.bean;

import java.util.Date;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * <pre>项目名称：ssm-task-zhangs    
 * 类名称：Log    
 * 类描述：    
 * 创建人：杨彦斌  
 * 创建时间：2019年1月6日 下午2:48:47    
 * 修改人：杨彦斌 
 * 修改时间：2019年1月6日 下午2:48:47    
 * 修改备注：       
 * @version </pre>    
 */
@Data

@Document(collection="login_log")
public class Log {
  private String id;
  private String logname;
  private String userid;
  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date logdate;
  private String lognodes;
  
//接收条件查询的临时字段
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Transient // 不映射到mongodb中
	private Date startTime;

	// 接收条件查询的临时字段
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Transient // 不映射到mongodb中
	private Date endTime;


	/**
	 * <pre>创建一个新的实例 Log.    
	 *    
	 * @param logname
	 * @param logdate
	 * @param lognodes</pre>    
	 */

	public Log(String logname, Date logdate, String lognodes) {
		super();
		this.logname = logname;
		this.logdate = logdate;
		this.lognodes = lognodes;
		
	}

	public Log() {
	}
}
