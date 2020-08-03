package com.qianluohan.basic.service.common.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianluohan.basic.dao.common.UserTokenDao;
import com.qianluohan.basic.entity.common.UserToken;
import com.qianluohan.basic.service.common.UserTokenService;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenDao, UserToken> implements UserTokenService {

    @Override
    public UserToken queryByToken(String token) {
        return this.getOne(new QueryWrapper<UserToken>().eq("token", token));
    }
}
