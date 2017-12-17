package com.cowboy.web.config.webmvc;/**
 * Created by Administrator on 2017/12/15/0015.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 如果Spring Boot 提供的Spring MVC 不符合要求,则可以通过一个配置类(注解有@Configuration的类)，加上@EnableWebMvc注解来实现完全自己控制的MVC配置。
 *既需要保留Spring Boot提供的便利,又需要增加自己的额外的配置的时候,可以定义一个配置类并继承WebMvcConfigureAdapter,不用使用@EnableWebMvc注解。
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-15 9:45
 **/
@Configuration
/*@EnableWebMvc*/
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * spring mvc 默认静态资源文件处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 静态资源路径指定
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       /* registry.addResourceHandler("/static*//**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/public*//**").addResourceLocations("classpath:/public/");
        registry.addResourceHandler("/resources*//**").addResourceLocations("classpath:/resources/");*/
    }

    /**
     * 视图解析类型指定
     * @return
     */
    @Bean
    public InternalResourceViewResolver defaultViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }
}
