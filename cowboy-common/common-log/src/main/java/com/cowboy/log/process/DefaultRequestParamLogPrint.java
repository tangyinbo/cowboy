package com.cowboy.log.process;/**
 * Created by Administrator on 2017/12/15/0015.
 */

import com.cowboy.log.annotation.RequestParamResultLogPrint;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.lang.annotation.Annotation;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-15 10:06
 **/
@Slf4j
public class DefaultRequestParamLogPrint implements RequestParamLogPrint {

    @Override
    public void printRequestParam(String typeName, String methodName, Object[] requestParams) {
        log.info("【目标方法】:{}.{},【请求参数】:", typeName, methodName, requestParams);
    }

    @Override
    public void printResponseReslt(String typeName, String methodName, Object result) {
        log.info("【目标方法】:{}.{},【响应结果】:", typeName, methodName, result);
    }

}
