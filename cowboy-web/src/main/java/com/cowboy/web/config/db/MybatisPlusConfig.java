package com.cowboy.web.config.db;/**
 * Created by Administrator on 2017/12/13/0013.
 */

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-13 15:14
 **/
@Configuration
public class MybatisPlusConfig {
    @Value("${mybatis.configLocation}")
    private String configLocation;
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    private ResourceLoader resourceLoader = new DefaultResourceLoader();

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        //mybatis 配置文件
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource(configLocation);
        mybatisSqlSessionFactoryBean.setConfigLocation(resource);
        //映射文件路径
      /*  resourcePatternResolver = new PathMatchingResourcePatternResolver();
        resource = resourcePatternResolver.getResource(mapperLocations);
        mybatisSqlSessionFactoryBean.setMapperLocations(new Resource[]{resource});*/
        //
        GlobalConfiguration globalConfig = new GlobalConfiguration();

        return mybatisSqlSessionFactoryBean;
    }


    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}
