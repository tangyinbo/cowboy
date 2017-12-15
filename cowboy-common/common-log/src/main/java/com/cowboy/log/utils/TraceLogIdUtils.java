package com.cowboy.log.utils;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * 日志追踪工具类
 * @version 1.0
 * @author Administrator
 * 2017年9月11日 上午9:57:11
 */
public class TraceLogIdUtils {
    /**
     * 日志追踪id key
     */
    public static final String TRACE_LOG_ID = "traceLogId";
    /**
     * 加入traceLogId
     * @param traceLogId
     */
    public static void putTraceLogId(String traceLogId){
        MDC.put(TRACE_LOG_ID,traceLogId);
    }

    /**
     * 清空日志追踪id
     * @author Administrator
     * @date 2017年9月11日
     */
    public static void remove(){
    	MDC.remove(TRACE_LOG_ID);
    }

    /**
     * 获取日志追踪id
     * @return
     */
    public static String get(){
        String traceLogId = MDC.get(TRACE_LOG_ID);
        return traceLogId == null?UUID.randomUUID().toString():traceLogId;
    }
}
