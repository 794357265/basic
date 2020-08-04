package com.qianluohan.basic.dao.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianluohan.basic.entity.common.UserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenDao extends BaseMapper<UserToken> {
}
