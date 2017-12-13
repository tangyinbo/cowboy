package com.cowboy.web.config.db;/**
 * Created by Administrator on 2017/12/13/0013.
 */

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-13 14:29
 **/
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MybatisMapperScannerConfig {
    @Value("${mybatis.mapperScannerConfigurer}")
    private String mapperScannerConfig;

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.cowboy.*.mapper");
        return mapperScannerConfigurer;
    }
}
