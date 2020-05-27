package com.dmsdbj.team3.javaprojectbestpractices.utils.aspect;

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
import java.lang.reflect.Method;

/**
 * @author rt
 * TODO: 切面类
 */
@Slf4j
@Aspect
@Component
//@Profile({"dev","test"})
public class LogAspect {
    ThreadLocal<String> tag = new ThreadLocal<String>();
    /** 换行符 */
    /** 换行符 */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 限额限日志的 trace id
     */
    private static final String TRACE_ID = "TRACE_ID";

    //以自定义 @Log注解为切点
    @Pointcut("@annotation(com.dmsdbj.team3.javaprojectbestpractices.utils.aspect.Log)")
    public void log() {
    }

    /**
     * 在所有标注@Log的地方切入
     *
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 获取 @WebLog 注解的描述信息
        String methodDescription = getAspectLogDescription(joinPoint);

        // 打印请求相关参数
        log.info("========================================== Start ==========================================");
        // 打印请求 url
        log.info("方法URL            : {}", request.getRequestURL().toString());
        // 打印描述信息
        log.info("方法Description    : {}", methodDescription);
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        log.info("Request Args   : {}", JSON.toJSON(joinPoint.getArgs()));

    }

    @After("log()")
    public void doAfter() {
        // 接口结束后换行，方便分割查看
        log.info("=========================================== End ===========================================" + LINE_SEPARATOR);
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        // 添加MDC
        MDC.put(TRACE_ID, IdWorker.getIdStr());

        Object result = pjp.proceed();
        // 打印出参
        log.info("Response Args  : {}", JSON.toJSON(result));
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        //移除MDC
        MDC.remove(TRACE_ID);

        return result;

    }

    @AfterThrowing(value = "log()", throwing = "exception")
    public void afterThrowingExec(JoinPoint joinPoint) {
        log.info("运行的切面joinPoint:[{}]", joinPoint);
        log.info("运行的线程tag:[{}]", tag.get());
    }

    /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(Log.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }
}
