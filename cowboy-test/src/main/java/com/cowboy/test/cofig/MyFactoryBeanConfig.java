package com.cowboy.test.cofig;/**
 * Created by Administrator on 2017/12/18/0018.
 */

import com.cowboy.test.factorybean.MyBean;
import com.cowboy.test.factorybean.MyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-18 11:21
 **/
@Configuration
public class MyFactoryBeanConfig {

    @Bean
    public MyFactoryBean factoryBean(){
        return new MyFactoryBean();
    }
}
