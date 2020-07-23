package com.qianluohan.basic.oauth2;

import com.qianluohan.basic.entity.common.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
* @author zhangyibing  zhangyibing@bmsoft.com.cn
* @Date 2020/7/23
* @desription 登录认证
**/
@Component
public class OAuth2Realm extends AuthorizingRealm {


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
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        //根据accessToken，查询用户信息
        //SysUserTokenEntity tokenEntity = shiroService.queryByToken(accessToken);
//        UserToken tokenEntity = sysUserTokenRedis.get(accessToken);
//        if(tokenEntity == null){
//            tokenEntity = shiroService.queryByToken(accessToken);
//            sysUserTokenRedis.saveOrUpdate(tokenEntity);
//        }
//        //token失效
//        if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
//            throw new IncorrectCredentialsException("token失效，请重新登录");
//        }
//
//        //查询用户信息
//        //SysUserEntity user = shiroService.queryUser(tokenEntity.getUserId());
//        User user = sysUserRedis.get(tokenEntity.getUserId());
//        if(user == null){
//            user = shiroService.queryUser(tokenEntity.getUserId());
//            sysUserRedis.saveOrUpdate(user);
//        }
//        //过期时间
//        Date expireTime = new Date(System.currentTimeMillis() + SysUserTokenServiceImpl.EXPIRE * 1000);
//        tokenEntity.setExpireTime(expireTime);
//        sysUserTokenRedis.saveOrUpdate(tokenEntity);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(new User(), accessToken, getName());
        System.out.println("doGetAuthenticationInfo-->"+info);
        throw new IncorrectCredentialsException("token失效，请重新登录");
//        return info;
    }
}
