package com.qianluohan.basic.exception;

import com.qianluohan.basic.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
* @author zhangyibing  qianluohan.com
* @Date 2020/6/1
* @desription 异常处理器
**/
@RestControllerAdvice
public class CustomizedExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(CustomizedException.class)
	public Result handleRRException(CustomizedException e){
		System.out.println("catch CustomizedException--");
		Result r = new Result();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());
		return r;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public Result handlerNoFoundException(Exception e) {
		System.out.println("catch NoHandlerFoundException--");
		logger.error(e.getMessage(), e);
		return Result.error(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e){
		logger.error(e.getMessage(), e);
		return Result.error().put("error", e.getMessage());
	}
}
