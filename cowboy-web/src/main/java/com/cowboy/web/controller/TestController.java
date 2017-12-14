package com.cowboy.web.controller;/**
 * Created by Administrator on 2017/12/14/0014.
 */

import com.cowboy.log.annotation.RequestParamResultLogPrint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-14 15:05
 **/
@RestController
public class TestController {
    @RequestMapping("/test")
    @RequestParamResultLogPrint
    public String test(){
        return "hello tangyinbo";
    }
}
