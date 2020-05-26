package com.dmsdbj.team3.javaprojectbestpractices.aspect;

//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
import java.lang.annotation.*;

/**
 * @author rt
 */
// 什么时候使用该注解，我们定义为运行时；
@Retention(RetentionPolicy.RUNTIME)
// 注解用于什么地方，我们定义为作用于方法上
@Target({ElementType.METHOD,ElementType.TYPE})
// 注解是否将包含在JavaDoc 中
@Documented
public @interface Log {
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "和空气";
}
