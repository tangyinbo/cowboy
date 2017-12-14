package com.cowboy.log.aspect;/**
 * Created by Administrator on 2017/12/14/0014.
 */

import com.sun.xml.internal.ws.util.CompletedFuture;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-14 14:29
 **/
@Aspect
@Component
@Scope()
@Slf4j
public class RequestParamLogAspect {
    @Pointcut("@annotation(com.cowboy.log.annotation.RequestParamResultLogPrint)")
    public void processPointCut() {
    }

    ;

    /**
     * 请求参数打印
     *
     * @param proceedingJoinPoint
     */
    public void beforeInvok(ProceedingJoinPoint proceedingJoinPoint) {
        Signature signature = proceedingJoinPoint.getSignature();
        log.info("【目标方法】:{}.{},【请求参数】:", signature.getDeclaringTypeName(), signature.getName(), proceedingJoinPoint.getArgs());
    }

    /**
     * @param proceedingJoinPoint
     * @param result
     */
    public void afterProcee(ProceedingJoinPoint proceedingJoinPoint, Object result) {
        Signature signature = proceedingJoinPoint.getSignature();
        log.info("【目标方法】:{}.{},【响应结果】:", signature.getDeclaringTypeName(), signature.getName(), result);
    }

    @Around("processPointCut()")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //调动前请求参数打印
        CompletableFuture.runAsync(() -> {
            beforeInvok(proceedingJoinPoint);
        });
        try {
            Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            //响应结果打印
            CompletableFuture.runAsync(() -> {
                afterProcee(proceedingJoinPoint, result);
            });
            return result;
        } catch (Throwable throwable) {
            CompletableFuture.runAsync(() -> {
                log.info("【目标方法】:{}.{},【调用异常,异常信息】:", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), throwable);
            });
            throw throwable;
        }
    }
}
