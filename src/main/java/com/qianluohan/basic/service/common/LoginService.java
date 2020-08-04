package com.qianluohan.basic.service.common;

import com.qianluohan.basic.utils.Result;

import java.util.Map;

public interface LoginService {

    void validateLoginForm(Map<String, Object> params);

    Result login(Map<String, Object> param);
}
