package com.cowboy.web.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by cowboy on 2017-12-17.
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        //自定义登陆录成功跳转,如果不加上下面这句的话登录成功有的时候不会跳转到自定义的successurl
        WebUtils.getAndClearSavedRequest(request);
        String successUrl = this.getSuccessUrl();
        WebUtils.redirectToSavedRequest(request, response, successUrl);
        return false;
        //return super.onLoginSuccess(token, subject, request, response);
    }
}
