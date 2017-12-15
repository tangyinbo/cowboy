package com.cowboy.web.config.common;/**
 * Created by Administrator on 2017/12/15/0015.
 */

import com.cowboy.log.process.RequestParamLogPrint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-15 16:42
 **/
@Configuration
@Slf4j
public class CommonConfig {
    /**
     * 方法拦截参数日志打印
     * @return
     */
    @Bean
    public RequestParamLogPrint requestParamLogPrint(){
        return new RequestParamLogPrint() {
            @Override
            public void printRequestParam(String typeName, String methodName, Object[] requestParams) {
                log.info("【目标方法】:{}.{},【请求参数】:{}", typeName, methodName, requestParams);
            }

            @Override
            public void printResponseReslt(String typeName, String methodName, Object result) {
                log.info("【目标方法】:{}.{},【响应结果】:{}", typeName, methodName, result);
            }
        };
    }
}
