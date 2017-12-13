package com.cowboy.web.config.db;/**
 * Created by Administrator on 2017/12/13/0013.
 */

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源使用配置
 * @author Tangyinbo
 * @version 1.0
 * @create 2017-12-13 9:42
 **/
@Configuration
public class DataSourceConfig {
    /**
     * 使用c3p0数据源
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }
}
