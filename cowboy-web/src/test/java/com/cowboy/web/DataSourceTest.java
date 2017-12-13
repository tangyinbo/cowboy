package com.cowboy.web;/**
 * Created by Administrator on 2017/12/13/0013.
 */

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.cowboy.CowobyApplicationTests;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Tangyinbo
 * @version 1.0
 * @create 2017-12-13 11:07
 **/
public class DataSourceTest extends CowobyApplicationTests{
    @Autowired
    private DataSource dataSource;
   /* @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;*/
    @Autowired
    private MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean;
    @Test
    public void test1() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
    @Test
    public void test2(){
        System.out.println("======================");
        System.out.println(mybatisSqlSessionFactoryBean);
    }
}
