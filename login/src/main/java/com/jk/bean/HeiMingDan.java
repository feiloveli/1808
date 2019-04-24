package com.jk.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description: 骚骚的🐏
 * @Author: 杨
 * @Date: 2019/2/4 09:54
 */
@Data
public class HeiMingDan {
    private Integer hid;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
}
