package com.qianluohan.basic.oauth2;

import com.qianluohan.basic.entity.common.User;
import com.qianluohan.basic.entity.common.UserToken;
import com.qianluohan.basic.service.common.UserService;
import com.qianluohan.basic.service.common.UserTokenService;
import com.qianluohan.basic.utils.Constant;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
* @author zhangyibing  zhangyibing618@163.com
* @Date 2020/7/23
* @desription 登录认证
**/
@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    private UserService userService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 请求授权(验证权限时调用，暂不做请求权限控制)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo();
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户信息
        UserToken userToken = userTokenService.queryByToken(accessToken);
        //token失效
        if(userToken == null || userToken.getExpireTime().getTime() < System.currentTimeMillis()){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        //查询用户信息
        User user = userService.getById(userToken.getUserId());
        if(user == null){
            throw new IncorrectCredentialsException("用户不存在，请确认用户名和密码正确");
        }
        //过期时间
        Date expireTime = new Date(System.currentTimeMillis() + Constant.EXPIRE * 1000);
        //每次请求刷新过期时间
        userToken.setExpireTime(expireTime);
        userTokenService.saveOrUpdate(userToken);

        return new SimpleAuthenticationInfo(user, accessToken, getName());
    }
}
