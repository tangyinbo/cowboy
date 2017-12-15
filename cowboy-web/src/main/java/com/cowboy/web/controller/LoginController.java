package com.cowboy.web.controller;/**
 * Created by Administrator on 2017/12/15/0015.
 */

import com.cowboy.log.annotation.RequestParamResultLogPrint;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-15 9:43
 **/
@Controller
@Slf4j
public class LoginController {
    @RequestMapping(value = "/login2",method = RequestMethod.GET)
    @RequestParamResultLogPrint
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/login")
    @RequestParamResultLogPrint
    public String login(HttpServletRequest request){
        //FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isRemembered() || currentUser.isAuthenticated()){
            return "index";
        }

        request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken();
        usernamePasswordToken.setUsername(userName);
        usernamePasswordToken.setPassword(password.toCharArray());
        currentUser.login(usernamePasswordToken);
        return "index";
    }
}
