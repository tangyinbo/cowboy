package com.cowboy.web.controller;/**
 * Created by Administrator on 2017/12/15/0015.
 */

import com.cowboy.comon.model.sys.CommonResponse;
import com.cowboy.comon.model.sys.CommonResultCode;
import com.cowboy.log.annotation.RequestParamResultLogPrint;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.java2d.SunGraphics2D;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-15 9:43
 **/
@Controller
@Slf4j
public class LoginController {
    /**
     * 当对页面进行访问时,没有权限时进入的连接
     *
     * @param model
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/logins")
    @RequestParamResultLogPrint
    public void login(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Subject s = SecurityUtils.getSubject();
        //是否允许访问
        boolean allowVisited = s.isRemembered() || s.isAuthenticated();
        boolean isremembered = s.isRemembered();
        boolean isAuthenticated = s.isAuthenticated();
        //允许访问跳转到首页,否则跳转到登录页面
        if (allowVisited) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("login.html");
        }
    }

    /**
     * shiro认证成功,会进入该方法进行实际页面跳转
     *
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/indexs", method = RequestMethod.GET)
    @ResponseBody
    public CommonResponse index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws IOException {
        Subject subject = SecurityUtils.getSubject();
        Object obj = subject.getPrincipal();
        //response.sendRedirect("index.html");
        log.info("resuestUrl:{}",request.getRequestURL());
        return CommonResponse.buildSuccessResult(null);
    }

    /**
     * shiro 认证失败会进入该地址
     *
     * @param request
     * @param redirectAttributes
     * @return
     */
    @PostMapping(value = "/logins")
    @RequestParamResultLogPrint
    @ResponseBody
    public CommonResponse login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        //获取认证失败的异常信息,一般为异常类全限定名
        String failMsg = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if(!StringUtils.isEmpty(failMsg)){
            log.error("登录认证失败:" + failMsg);
            //账号或者密码错误
            if("org.apache.shiro.authc.IncorrectCredentialsException".equals(failMsg)){
                return CommonResponse.buildFailResult(CommonResultCode.LOGIN_CREDENTIALS_ERROR);
            }else{
                return CommonResponse.buildFailResult(CommonResultCode.FAIL);
            }
        }
        return CommonResponse.buildSuccessResult(null);
    }
}
