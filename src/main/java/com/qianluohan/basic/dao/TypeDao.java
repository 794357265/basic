package com.qianluohan.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianluohan.basic.entity.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeDao extends BaseMapper<Type> {


    Page<Type> list(Page<?> page);

}
