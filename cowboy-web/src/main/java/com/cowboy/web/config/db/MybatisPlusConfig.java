package com.cowboy.web.config.db;/**
 * Created by Administrator on 2017/12/13/0013.
 */

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * mybatis plus 配置
 *
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-13 15:14
 **/
@Configuration
@MapperScan(basePackages = {"com.cowboy.*.dao"})
public class MybatisPlusConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * mybatis 全局配置
     *
     * @return
     */
    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration globalConfiguration = new GlobalConfiguration();
        globalConfiguration.setIdType(IdType.AUTO.getKey());
        return globalConfiguration;
    }

    /**
     * mybatis plus 配置
     *
     * @param globalConfiguration
     * @return
     */
    @ConfigurationProperties(prefix = "mybatis-plus")
    @Bean
    @Primary
    public MybatisSqlSessionFactoryBean sqlSessionFactoryBean(GlobalConfiguration globalConfiguration) {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        //注入全局配置
        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfiguration);
        return mybatisSqlSessionFactoryBean;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType(DBType.MYSQL.getDb());
        return page;
    }

    /**
     * 事物配置
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
