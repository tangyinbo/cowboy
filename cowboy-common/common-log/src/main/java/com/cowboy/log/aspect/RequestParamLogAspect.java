package com.cowboy.log.aspect;/**
 * Created by Administrator on 2017/12/14/0014.
 */

import com.cowboy.log.annotation.RequestParamResultLogPrint;
import com.cowboy.log.process.DefaultRequestParamLogPrint;
import com.cowboy.log.process.RequestParamLogPrint;
import com.cowboy.log.utils.TraceLogIdUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
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

    private RequestParamLogPrint requestParamLogPrint;

    @Autowired(required = false)
    public RequestParamLogAspect(RequestParamLogPrint requestParamLogPrint) {
       this.requestParamLogPrint = Optional.ofNullable(requestParamLogPrint).orElseGet(DefaultRequestParamLogPrint::new);
    }

    @Pointcut("@annotation(com.cowboy.log.annotation.RequestParamResultLogPrint)")
    public void processPointCut() {
    }


    @Around("processPointCut()")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        String traceLogId = UUID.randomUUID().toString();
        TraceLogIdUtils.putTraceLogId(traceLogId);
        //调动前请求参数打印
        CompletableFuture.runAsync(() -> {
            try{
                TraceLogIdUtils.putTraceLogId(traceLogId);
                requestParamLogPrint.printRequestParam(signature.getDeclaringTypeName(),signature.getName(),proceedingJoinPoint.getArgs());
            }finally{
                TraceLogIdUtils.remove();
            }
        });
        try {
            Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            //响应结果打印
            CompletableFuture.runAsync(() -> {
                try{
                    TraceLogIdUtils.putTraceLogId(traceLogId);
                    requestParamLogPrint.printResponseReslt(signature.getDeclaringTypeName(),signature.getName(),result);
                }finally{
                    TraceLogIdUtils.remove();
                }
            });
            return result;
        } catch (Throwable throwable) {
            CompletableFuture.runAsync(() -> {
                log.info("【目标方法】:{}.{},【调用异常,异常信息】:", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), throwable);
            });
            throw throwable;
        }finally{
            TraceLogIdUtils.remove();
        }
    }
}
