/** 
 * <pre>项目名称:eazyui 
 * 文件名称:ReceivePage.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018-11-29下午4:27:39 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.util;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** 
 * <pre>项目名称：eazyui    
 * 类名称：ReceivePage    
 * 类描述：    
 * 创建人：杨彦斌  
 * 创建时间：2018-11-29 下午4:27:39    
 * 修改人：杨彦斌 
 * 修改时间：2018-11-29 下午4:27:39    
 * 修改备注：       
 * @version </pre>    
 */

/**
 * 分页数据接收工具类
 * @author 杨彦斌 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class PageParam implements Serializable {
	
	/*   分页      */
    private Integer page; //当前页
	
    private Integer rows; //每页几条
}
