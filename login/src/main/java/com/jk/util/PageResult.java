package com.jk.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回工具类
 * @author 杨彦斌 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class PageResult implements Serializable {

	private Integer total;
	
	private List  rows;

	
}
