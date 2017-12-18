package com.cowboy.test.controller;/**
 * Created by Administrator on 2017/12/18/0018.
 */

import com.cowboy.test.factorybean.ContextBean;
import com.cowboy.test.factorybean.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-18 11:26
 **/
@RestController
public class TestController {
    @Autowired
    private ContextBean contextBean;
    @RequestMapping("/test")
    public String test(){
        MyBean myBean = contextBean.getApplicationContext().getBean(MyBean.class);
        myBean.sayHello();
        return "kakakaka";
    }
}
