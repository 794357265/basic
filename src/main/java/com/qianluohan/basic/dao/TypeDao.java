package com.qianluohan.basic.dao;

import com.qianluohan.basic.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeDao {

    void saveItems(List<Item> items);

}
