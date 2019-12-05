package com.dmsdbj.team3.javaprojectbestpractices.Aop;
import	java.lang.annotation.ElementType;
import	java.lang.annotation.Target;
import	java.lang.annotation.RetentionPolicy;
import	java.lang.annotation.Retention;

import java.lang.annotation.Documented;

/**
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-12-03
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String description() default "";
}
