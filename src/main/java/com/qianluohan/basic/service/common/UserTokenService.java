package com.qianluohan.basic.service.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qianluohan.basic.entity.common.UserToken;
import com.qianluohan.basic.utils.Result;

public interface UserTokenService extends IService<UserToken> {

    UserToken queryByToken(String token);

    Result createToken(String userId);
}
