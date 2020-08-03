package com.qianluohan.basic.entity.common;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {

    private String id;

    private String username;

    private String password;

    private String mail;

}
