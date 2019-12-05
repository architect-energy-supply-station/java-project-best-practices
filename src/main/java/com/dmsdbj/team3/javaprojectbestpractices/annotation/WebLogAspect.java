package com.dmsdbj.team3.javaprojectbestpractices.annotation;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/3 4:35 下午
 * @Version 1.0
 * @Description
 **/

@Aspect
@Component
public class WebLogAspect {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final static String LINE_SEPARATOR = System.lineSeparator();
    private static final String TRACE_ID = "TRACE_ID";


    @Pointcut("@annotation(com.dmsdbj.team3.javaprojectbestpractices.annotation.WebLog)")
    public void WebLog() {
    }

    @Around("WebLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MDC.put(TRACE_ID, IdWorker.getIdStr());
        logger.info("Begin Around   ");
        long currentTimeMillis = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        //打印出参
        logger.info("response Args : {}", new Gson().toJson(result));
        logger.info("Time consuming : {} ms", System.currentTimeMillis() - currentTimeMillis);
        MDC.remove(TRACE_ID);
        return result;
    }


    @Before("WebLog()")
    public void doBefore(JoinPoint joinpoint) throws Exception {
        //开始打印请求日志
        ServletRequestAttributes contextHolder = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = contextHolder.getRequest();

        //获取WebLog注解的描述信息
        String methodDescription = getAspectLogDescription(joinpoint);
        //打印相关参数
        logger.info("    start        ");
        logger.info("URL            :{}", request.getRequestURL());
        logger.info("Description    :{}", methodDescription.toString());
        logger.info("HTTP Method     :{}", request.getMethod());
        logger.info("Class Method    :{}.{}", joinpoint.getSignature().getDeclaringTypeName(), joinpoint.getSignature().getName());
        logger.info("IP         :{}", request.getRemoteAddr());
        logger.info("Request Args    :{}", new Gson().toJson(joinpoint.getArgs()));
    }


    @After("WebLog()")
    public void doAfter(JoinPoint joinpoint) {
        //接口结束后换行，方便分割查看
        logger.info("It's The End" + LINE_SEPARATOR);
    }


    public String getAspectLogDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] argsName = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuffer description = new StringBuffer("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==argsName.length) {
                    description.append(method.getAnnotation(WebLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }
}
