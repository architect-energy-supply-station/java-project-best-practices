package com.dmsdbj.team3.javaprojectbestpractices.annotation;

import net.bytebuddy.dynamic.scaffold.TypeInitializer;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {

    String description() default "";
}
