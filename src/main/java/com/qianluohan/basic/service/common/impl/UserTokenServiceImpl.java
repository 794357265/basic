package com.qianluohan.basic.service.common.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianluohan.basic.dao.common.UserTokenDao;
import com.qianluohan.basic.entity.common.UserToken;
import com.qianluohan.basic.oauth2.TokenGenerator;
import com.qianluohan.basic.service.common.UserTokenService;
import com.qianluohan.basic.utils.Constant;
import com.qianluohan.basic.utils.Result;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenDao, UserToken> implements UserTokenService {

    @Override
    public UserToken queryByToken(String token) {
        return this.getOne(new QueryWrapper<UserToken>().eq("token", token));
    }

    @Override
    public Result createToken(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + Constant.EXPIRE * 1000);

        //判断是否生成过token
        UserToken userToken = this.getById(userId);
        if(userToken == null){
            userToken = new UserToken();
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);

            //保存token
            this.save(userToken);
        }else{
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);

            //更新token
            this.updateById(userToken);
        }
        return Result.ok().put("token", token).put("expire", Constant.EXPIRE);
    }
}
