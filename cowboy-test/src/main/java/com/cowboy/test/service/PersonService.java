package com.cowboy.test.service;/**
 * Created by Administrator on 2017/12/6/0006.
 */

import com.alibaba.fastjson.JSON;
import com.cowboy.test.cofig.NameProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-12-06 14:29
 **/
public class PersonService {
    private NameProperties nameProperties;

    @PostConstruct
    public void init(){
        System.out.println("----------PersonService.init()-----------"+ JSON.toJSONString(nameProperties));
    }
}
