package com.qianluohan.basic.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
* @author zhangyibing  zhangyibing@bmsoft.com.cn
* @Date 2020/6/1
* @desription 数据返回模型
**/
public class Result extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;
	
	public Result() {
		put("code", 200);
		put("msg", "success");
	}
	
	public static Result error() {
		return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
	}
	
	public static Result error(String msg) {
		return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
	}
	
	public static Result error(int code, String msg) {
		Result r = new Result();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static Result ok() {
		return new Result();
	}

	public static Result ok(String msg) {
		Result r = new Result();
		r.put("msg", msg);
		return r;
	}
	
	public static Result ok(Map<String, Object> map) {
		Result r = new Result();
		r.putAll(map);
		return r;
	}

	@Override
	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
