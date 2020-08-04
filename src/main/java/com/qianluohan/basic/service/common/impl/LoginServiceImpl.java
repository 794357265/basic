package com.qianluohan.basic.service.common.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qianluohan.basic.dao.common.LoginDao;
import com.qianluohan.basic.entity.common.Captcha;
import com.qianluohan.basic.entity.common.User;
import com.qianluohan.basic.exception.CustomizedException;
import com.qianluohan.basic.service.common.LoginService;
import com.qianluohan.basic.service.common.UserService;
import com.qianluohan.basic.service.common.UserTokenService;
import com.qianluohan.basic.utils.Result;
import com.qianluohan.basic.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTokenService userTokenService;

    @Value("${com.qianluohan.isCaptcha}")
    private boolean isCaptcha;

    @Override
    public Result login(Map<String, Object> param) {
        String username = param.get("username")+"";
        String password = param.get("password")+"";
        if(StringUtils.isNull(username) || StringUtils.isNull(password)){
            throw new CustomizedException("用户名或密码为空");
        }
        if(isCaptcha){
            validateLoginForm(param);
        }
        User user = userService.getOne(new QueryWrapper<User>()
                .eq("username", username).eq("password", password));
        if(StringUtils.isNull(user)){
            throw new CustomizedException("用户名或密码错误");
        }
        return userTokenService.createToken(user.getId());
    }

    @Override
    public void validateLoginForm(Map<String, Object> params) {
        Captcha captcha = loginDao.validateLoginForm(params);
        if(StringUtils.isNull(captcha)){
            throw new CustomizedException("验证码错误，请重新输入");
        }
        if(captcha.getExpireTime().before(new Date())){
            throw new CustomizedException("验证码已过期，请重新获取");
        }
    }
}
