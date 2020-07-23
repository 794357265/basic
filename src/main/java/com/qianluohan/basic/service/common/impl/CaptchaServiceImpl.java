package com.qianluohan.basic.service.common.impl;

import com.google.code.kaptcha.Producer;
import com.qianluohan.basic.entity.common.Captcha;
import com.qianluohan.basic.exception.CustomizedException;
import com.qianluohan.basic.service.common.CaptchaService;
import com.qianluohan.basic.utils.DateUtils;
import com.qianluohan.basic.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

@Service("captchaService")
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isNull(uuid)){
            throw new CustomizedException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();

        Captcha captchaEntity = new Captcha();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        //this.save(captchaEntity);

        return producer.createImage(code);
    }
}
