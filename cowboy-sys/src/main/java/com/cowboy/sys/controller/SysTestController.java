package com.cowboy.sys.controller;

import com.cowboy.log.annotation.RequestParamResultLogPrint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cowboy on 2017-12-16.
 */
@Controller
public class SysTestController {
    @RequestMapping("/sys")
    @RequestParamResultLogPrint
    public String sys(){
        return "sys";
    }
    @RequestMapping("/sys2")
    @RequestParamResultLogPrint
    public String sys2(){
        return "sys2";
    }
}
