package com.dmsdbj.team3.javaprojectbestpractices.utils.log;

import java.lang.annotation.*;

/**
 * @Classname Log
 * @Auther sunshinezhang
 * @Date 2019/11/4 18:37
 */


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

	//日志描述信息
	String description() default "";
}
