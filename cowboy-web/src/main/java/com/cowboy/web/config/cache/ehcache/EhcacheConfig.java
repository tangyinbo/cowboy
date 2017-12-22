package com.cowboy.web.config.cache.ehcache;/**
 * Created by Administrator on 2017/12/21/0021.
 */


import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-21 15:46
 **/
@Configuration
public class EhcacheConfig {
    @Bean
    public KeyGenerator myKeyGenerator(){
        return new MyKeyGenerator();
    }
}
