package com.qianluohan.basic.dao.common;

import com.qianluohan.basic.entity.common.Captcha;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface LoginDao {

    Captcha validateLoginForm(@Param("params") Map<String,Object> params);

}
