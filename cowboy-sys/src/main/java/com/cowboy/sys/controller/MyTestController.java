package com.cowboy.sys.controller;/**
 * Created by Administrator on 2017/12/6/0006.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-12-06 11:57
 **/
@RestController
public class MyTestController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello tangy8inbo.";
    }
}
