package com.dmsdbj.team3.javaprojectbestpractices.Aop;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-12-03
 */
@Slf4j
@Component
@Aspect
public class LogAop {
    ThreadLocal<Long> time=new ThreadLocal<Long> ();
    ThreadLocal<String> tag=new ThreadLocal<String> ();
    private static String TRACE_ID = "TRACE_ID";

    //定义切入点
    @Pointcut("@annotation(com.dmsdbj.team3.javaprojectbestpractices.Aop.Log)")
    public void log() {
        System.out.println("我是一个切入点");
    }

    // 前置
    @Before("log()")
    public void beforeExec(JoinPoint joinPoint) {

        System.out.println("=========== before ===========");
        time.set(System.currentTimeMillis());
    }

    // 后置
    @After("log()")
    public void afterExec(JoinPoint joinPoint) {
        tag.set(IdWorker.getIdStr());
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodname = joinPoint.getSignature().getName();
        Object[] os = joinPoint.getArgs();
        String remoteAddr = request.getRemoteAddr();
        log.info("后置通知");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < os.length; i++) {
            stringBuilder.append("参数").append(i + 1).append(":").append(os[i]);
        }

        Long l = System.currentTimeMillis() - time.get();
        log.info("运行的类classname:[{}]", className);
        log.info("运行的方法methodname:[{}]", methodname);
        log.info("运行的远程地址是remoteAddr:[{}]", remoteAddr);
        log.info("运行的方法时间time:[{}]", l);
    }

    // 环绕
    @Around("log()")
    public Object arroudExec(ProceedingJoinPoint pjp) throws Throwable {
        long startTime=System.currentTimeMillis();
        MDC.put(TRACE_ID,IdWorker.getIdStr());
        Object result = pjp.proceed();

        //打印出参
        log.info("Response Args :{}", JSON.toJSON(result));
        // 执行耗时
        log.info("Time consuming: {}ms" , System.currentTimeMillis()-startTime);
        MDC.remove(TRACE_ID);
        return result;
    }

    //异常通知
    @AfterThrowing(value = "log()")
    public void afterThrowingExec(JoinPoint joinPoint) {
        log.info("运行的切面joinPoint:[{}]", joinPoint);
        log.info("运行的线程tag:[{}]", tag.get());
    }
}
