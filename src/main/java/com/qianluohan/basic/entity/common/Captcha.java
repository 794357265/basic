package com.qianluohan.basic.entity.common;

import lombok.Data;

import java.util.Date;

/**
 * 系统验证码
 *
 * @author luyuwei luyuwei@bmsoft.com.cn
 */
@Data
public class Captcha {

    private String uuid;

    /**
     * 验证码
     */
    private String code;

    /**
     * 过期时间
     */
    private Date expireTime;

}
