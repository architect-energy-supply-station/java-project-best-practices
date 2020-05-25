package com.dmsdbj.team3.javaprojectbestpractices.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author rt
 * TODO: 切面类
 */
@Aspect
@Component
@Profile({"dev","test"})
public class WebLogAspect {
    Class clazz;
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**以自定义 @WebLog 注解为切点*/
    @Pointcut("@annotation(com.dmsdbj.team3.javaprojectbestpractices.aspect.WebLog)")
    public void webLog() { }

    /**
     * 在切点之前织入
     * @param joinPoint
     * @throws Throwable
     */
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 获取 @WebLog 注解的描述信息
        String methodDescription = getAspectLogDescription(joinPoint);
        // 打印请求相关参数
        logger.info("==============================================Start===========================");
        // 打印请求url
        logger.info("URL    :{}", request.getRequestURI().toString());
        // 打印描述信息
        logger.info("Description    : {}", methodDescription);
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));

    }

    /**
     * 在切点之后织入
     * @throws Throwable
     */
    public void adAfter() throws Throwable {
        // 接口接收后换行，方便分割查看
    logger.info("====================================================End==================================");
}
public Object doAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable {
    long startTime = System.currentTimeMillis();
    Object result = proceedingJoinPoint.proceed();
    // 打印出参
    logger.info("Response Args: {}", new Gson().toJson(result));
    // 执行耗时
    logger.info("Time-Consuming :{} ms", System.currentTimeMillis() - startTime);
    return result;
}

    /**
     * 获取切面注解的描述
     * @param joinPoint 切点
     * @return
     */
    private String getAspectLogDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String  methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder decription = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    decription.append(method.getAnnotation(WebLog.class).description());
                    break;
                }
            }
        }
        return decription.toString();
    }
}
