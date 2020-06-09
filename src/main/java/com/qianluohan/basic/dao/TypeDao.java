package com.qianluohan.basic.dao;

import com.github.pagehelper.Page;
import com.qianluohan.basic.entity.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeDao {


    Page<Type> list();

}
