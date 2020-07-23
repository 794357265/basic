package com.qianluohan.basic.controller.common;

import com.qianluohan.basic.entity.common.User;
import com.qianluohan.basic.exception.CustomizedException;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author zhangyibing  zhangyibing@bmsoft.com.cn
* @Date 2020/7/23
* @desription controller公共组件，用于获取当前登录用户
**/
public abstract class AbstractController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 获取当前用户信息
	 * @return SysUserEntity
	 */
	protected User getUser() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 获取当前用户ID
	 * @return String
	 */
	protected String getUserId() {
		User user = getUser();
		if(user != null){
			return user.getId();
		}
		throw new CustomizedException("token过期或用户不存在，请重新登录", 401);
	}
}
