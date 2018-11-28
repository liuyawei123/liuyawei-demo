package com.primeton.demo.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.primeton.demo.excption.DemoException;
import com.primeton.demo.model.ResponseResult;

/**
 * 统一异常处理 
 * 
 * @author liuya
 *
 */
@RestControllerAdvice
public class CommonExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseResult<Void> handleServiceException(HttpServletRequest req, HttpServletResponse res, Exception e) {

		if (e instanceof DemoException) {
			logger.error("很遺憾您出現了" + e.getMessage() + "请及时处理", e);
			DemoException demoException = (DemoException) e;
			return new ResponseResult<Void>(demoException.getErrCode(), demoException.getMessage());
		} else {
			logger.error("很遺憾您出現了" + e.getMessage() + "请及时处理", e);
			return new ResponseResult<Void>(500, "您有可能变量，地址书写错误，或者代码出现错误");
		}

	}
}
