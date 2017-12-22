package com.cowboy.test.spel;/**
 * Created by Administrator on 2017/12/21/0021.
 */

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-21 11:29
 **/
@RestController
public class SpelController{
    @PostConstruct
    public void init(){
        System.out.println("===============PostConstruct");
    }
    @Value("#{spelProBean.name}")
    private String name;
    @Value("#{T(com.cowboy.test.spel.SpelProBean).getSps().?[not (name  eq 'name2')]}")
    private List<Sp> sps;

    @Value("#{T(com.cowboy.test.spel.SpelProBean).getMyName()?.toUpperCase()}")
    private String myName;

    @Value("#{T(com.cowboy.test.spel.SpelProBean).getSps().![name]}")
    private List<String> spsNames;

    @Value("#{T(com.cowboy.test.spel.SpelProBean).testName}")
    private String testName;

    @Value("#{T(com.cowboy.test.spel.SpEnum).RED.getName()}")
    private String enumStr;

    @RequestMapping("/getName")
    public String getName(){

        IntStream.range(1,5).forEach(i->{
            System.out.println(i);
        });
        return name +" - " + myName + "sps:"+ JSON.toJSONString(sps)+"<br/> spsNames:"+JSON.toJSONString(spsNames);
    }

    @RequestMapping("/test2")
    public String test2(){
        return "testName:"+testName +" -- enumStr:"+enumStr;
    }

 /*   @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("===============postProcessBeforeInitialization"+o.getClass().getSimpleName() +"--"+s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("===============postProcessAfterInitialization"+o.getClass().getSimpleName() +"--"+s);
        return o;
    }*/
}
