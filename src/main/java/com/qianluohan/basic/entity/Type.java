package com.qianluohan.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_type")
public class Type {

    private String id;

    private String name;

    private String cons;

}
