package com.qianluohan.basic.entity.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* @author zhangyibing  zhangyibing@bmsoft.com.cn
* @Date 2020/7/23
* @desription 用户token关联表
**/
@Data
//@TableName("t_user_token")
public class UserToken implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private String userId;
	//token
	private String token;
	//过期时间
	private Date expireTime;
	//更新时间
	private Date updateTime;

}
