package com.dmsdbj.team3.javaprojectbestpractices.handler;

import com.dmsdbj.team3.javaprojectbestpractices.config.ResultBean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;




/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/6 5:07 下午
 * @Version 1.0
 * @Description
 **/

@Slf4j
@ResponseBody
@ControllerAdvice
public class exceptionHandler {
    @ExceptionHandler
    public ResultBean methodArgumentNotValid(BindException e) {
        log.error("参数校验失败", e);
        StringBuffer errorBuffer = new StringBuffer();
        e.getAllErrors().forEach(objectError ->
                errorBuffer.append(objectError.getDefaultMessage()).append(","));
        return ResultBean.error(1111, errorBuffer.toString());
    }

    @ExceptionHandler
    public ResultBean unKnowException(Exception e) {
        log.error("未知异常", e);
        return ResultBean.error(-1111, "发生未知异常，请联系管理员");
    }

    @ExceptionHandler
    public ResultBean methodArgumentNotValidForJsonArgumentResolver(MethodArgumentNotValidException e) {
        log.error("json参数绑定到对象失败", e);
        StringBuffer errorMessage = new StringBuffer();
        e.getBindingResult().getAllErrors().forEach(objectError -> errorMessage.append(objectError.getDefaultMessage()).append(","));
        return ResultBean.error(1111, errorMessage.toString());
    }
}
