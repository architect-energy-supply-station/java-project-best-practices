package com.dmsdbj.team3.javaprojectbestpractices.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-12-05
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class exceptionHandler {
    @ExceptionHandler
    public ResultBean methodArgumentNotAvalid(BindException e) {
        log.error("参数校验失败",e);
        StringBuilder errorMessage = new StringBuilder();
        e.getAllErrors().forEach(objectError ->
                errorMessage.append(objectError.getDefaultMessage()).append(",")
        );
        return ResultBean.error(1, errorMessage.toString());
    }

    @ExceptionHandler
    public ResultBean methodArgumentNotAvalidForJsonArgumentResolver(MethodArgumentNotValidException e) {
        log.error("json参数绑定到对象失败", e);
        StringBuilder errorMessage = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(objectError ->
                errorMessage.append(objectError.getDefaultMessage()).append(",")
        );
        return ResultBean.error(1, errorMessage.toString());
    }

    @ExceptionHandler
    public ResultBean unKnownException(Exception e) {
        log.error("未知异常", e);
        //发送邮件，或者短信通知
        return ResultBean.error(-999, "发生了未知异常，请联系系统管理员");
    }
}
