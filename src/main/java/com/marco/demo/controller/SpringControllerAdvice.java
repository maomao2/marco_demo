package com.marco.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.marco.demo.entity.enums.ApiResultType;
import com.marco.demo.entity.enums.ManagerResultType;
import com.marco.demo.entity.result.MapStringResult;

@ControllerAdvice
@CrossOrigin
public class SpringControllerAdvice {
	private Logger logger = LogManager.getLogger(SpringControllerAdvice.class);

	/**
	 * 404
	 * @param ex
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseBody
	public MapStringResult noHandlerFound(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		return new MapStringResult(ApiResultType.NO_FOUND, null);
	}

	/**
	 * 其他异常
	 * @param ex
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public MapStringResult handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		logger.error(ex);
		return new MapStringResult(ManagerResultType.UNKNOW_ERROR.getCode(), ex.getMessage(), null);
	}
}