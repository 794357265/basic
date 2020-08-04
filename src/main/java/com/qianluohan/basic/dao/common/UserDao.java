package com.qianluohan.basic.dao.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianluohan.basic.entity.common.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
