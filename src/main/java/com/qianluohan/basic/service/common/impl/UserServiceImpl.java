package com.qianluohan.basic.service.common.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianluohan.basic.dao.common.UserDao;
import com.qianluohan.basic.entity.common.User;
import com.qianluohan.basic.service.common.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
