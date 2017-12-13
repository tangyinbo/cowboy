package com.cowboy.web.config;/**
 * Created by Administrator on 2017/12/13/0013.
 */

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 默认json转换器配置
 * @author Tangyinbo
 * @version 1.0
 * @create 2017-12-13 11:29
 **/
@Configuration
public class JsonConvertionConfig {

    @Bean
    public HttpMessageConverters fastjsonHttpMessageConverters(){

        //fastjson 消息转换对象
        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
        //配置对象
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //空属性也格式化显示
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        messageConverter.setFastJsonConfig(config);
        return new HttpMessageConverters(messageConverter);
    }
}
