package com.qianluohan.basic.config;

import com.qianluohan.basic.oauth2.OAuth2Filter;
import com.qianluohan.basic.oauth2.OAuth2Realm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* @author zhangyibing  zhangyibing618@163.com
* @Date 2020/7/23
* @desription shiro配置
**/
@Configuration
public class ShiroConfig implements EnvironmentAware {

    private String isLogin;
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        setIsLogin();
    }

    private void setIsLogin(){
        this.isLogin = environment.getProperty("com.qianluohan.isLogin");
    }

    @Bean("securityManager")
    public SecurityManager securityManager(OAuth2Realm oAuth2Realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(oAuth2Realm);
        securityManager.setRememberMeManager(null);
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        System.out.println("isLogin-->>"+ isLogin);
        //判断是否开启登录
        if("true".equals(isLogin)){
            //oauth过滤
            Map<String, Filter> filters = new HashMap<>();
            filters.put("oauth2", new OAuth2Filter());
            shiroFilter.setFilters(filters);

            Map<String, String> filterMap = new LinkedHashMap<>();
            //设置不过滤的接口地址
            filterMap.put("/favicon.ico", "anon");
            //获取验证码
            filterMap.put("/captcha.jpg", "anon");
            //登录
            filterMap.put("/login", "anon");
            filterMap.put("/**", "oauth2");
            shiroFilter.setFilterChainDefinitionMap(filterMap);
        }
        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}
