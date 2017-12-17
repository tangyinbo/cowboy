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

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 配置
 * @author Tangyinbo
 * @version 1.0
 * @create 2017-12-14 17:47
 **/
@Configuration
@Slf4j
public class ShiroConfig {
    /**
     * 创建shiro过滤器
     * @param userRealm
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(UserRealm userRealm) {
        //shiro过滤器
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager(userRealm));

        Map<String,Filter> shiroFilters = shiroFilterFactoryBean.getFilters();
        shiroFilters.put("authc", new MyFormAuthenticationFilter());

        //loginUrl认证提交地址，如果没有认证将会请求此地址进行认证，请求此地址将由formAuthenticationFilter进行表单认证
        shiroFilterFactoryBean.setLoginUrl("/logins");
        shiroFilterFactoryBean.setSuccessUrl("/indexs");
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/logouts", "logout");
        //开放的静态资源
        filterChainDefinitionMap.put("/bootstrap-dist/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/font-awesome/**", "anon");
        filterChainDefinitionMap.put("/frontend_theme/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/login.html", "anon");
        filterChainDefinitionMap.put("/index.html", "authc");

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
