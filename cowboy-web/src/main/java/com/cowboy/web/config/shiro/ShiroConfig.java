package com.cowboy.web.config.shiro;/**
 * Created by Administrator on 2017/12/14/0014.
 */

import com.cowboy.sys.shiro.UserRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * shiro 配置
 *
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-14 17:47
 **/
@Configuration
@Slf4j
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(UserRealm userRealm) {
        //shiro过滤器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager(userRealm));
        //loginUrl认证提交地址，如果没有认证将会请求此地址进行认证，请求此地址将由formAuthenticationFilter进行表单认证
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/logout", "logout");
        //开放的静态资源
  /*      filterChainDefinitionMap.put("/favicon.ico", "anon");//网站图标*/
        filterChainDefinitionMap.put("/webapp/**", "anon");
/*        filterChainDefinitionMap.put("/js*//**", "anon");
        filterChainDefinitionMap.put("/img*//**", "anon");
        filterChainDefinitionMap.put("/fonts*//**", "anon");*/

        filterChainDefinitionMap.put("/layouts/**", "anon");
        filterChainDefinitionMap.put("/attach/**", "anon");


        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/*.*", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * shiro 核心securityManager
     *
     * @param userRealm
     * @return
     */
    @Bean
    public SecurityManager securityManager(UserRealm userRealm) {
        //默认安全管理器
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm
        securityManager.setRealm(userRealm);

        //注入缓存管理器;
        //注意:开发时请先关闭，如不关闭热启动会报错
        //securityManager.setCacheManager();

        //记住我管理器
        //securityManager.setRememberMeManager();
        return securityManager;
    }


}
