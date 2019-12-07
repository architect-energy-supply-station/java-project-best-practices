package com.dmsdbj.team3.javaprojectbestpractices.utils.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname exception
 * @Auther sunshinezhang
 * @Date 2019/12/3 13:48
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class exceptionHandler {
	@ExceptionHandler
	public ResultBean methodArgumentNotValid(BindException e) {
		log.error("参数校验失败",e);
		StringBuilder errorMessage = new StringBuilder();
		e.getAllErrors().forEach(objectError ->
				errorMessage.append(objectError.getDefaultMessage()).append(",")
		);
		return ResultBean.error(1, errorMessage.toString());
	}

	@ExceptionHandler
	public ResultBean methodArgumentNotValidForJsonArgumentResolver(MethodArgumentNotValidException e) {
		log.error("json参数绑定到对象失败",e);
		StringBuilder errorMessage = new StringBuilder();
		e.getBindingResult().getAllErrors().forEach( errors-> errorMessage.append(errors.getDefaultMessage()).append(",") );
		return ResultBean.error(1, errorMessage.toString());
	}

	@ExceptionHandler
	public ResultBean unKnowException(Exception e) {
		log.error("未知异常", e);
		//发送邮件，或者短信通知
		return ResultBean.error(-999, "发生了未知异常，请联系系统管理员");
	}

	/**
	 * 404异常处理
	 */
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public ResultBean NoHandlerFoundExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
		log.debug("异常详情", e);
		return ResultBean.error(404, "页面不存在");
	}
}
