package com.qianluohan.basic.dao.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianluohan.basic.entity.common.Captcha;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zhangyibing  zhangyibing618@163.com
* @Date 2020/8/3
* @desription
**/
@Mapper
public interface CaptchaDao extends BaseMapper<Captcha> {
}
