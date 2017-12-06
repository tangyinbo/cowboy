package com.cowboy.test.cofig;/**
 * Created by Administrator on 2017/12/6/0006.
 */

import com.alibaba.fastjson.JSON;
import com.cowboy.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-12-06 14:26
 **/
@Configuration
@EnableConfigurationProperties(NameProperties.class)
public class ConditionConfigEdu {
    @Autowired
    private NameProperties nameProperties;
    @Bean
    @ConditionalOnProperty(prefix = "tangyinbo", name = {"kaka"},havingValue = "dd",matchIfMissing = true)
    public PersonService personService(){
        PersonService personService  = new PersonService();
        System.out.println("===================================");
        System.out.println("nameProperties:"+ JSON.toJSONString(nameProperties));
        return personService;
    }
}
