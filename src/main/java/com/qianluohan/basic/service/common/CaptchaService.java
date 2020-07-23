package com.qianluohan.basic.service.common;

import java.awt.image.BufferedImage;

public interface CaptchaService {

    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);
}
