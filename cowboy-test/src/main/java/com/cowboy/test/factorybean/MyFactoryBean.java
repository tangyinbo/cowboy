package com.cowboy.test.factorybean;/**
 * Created by Administrator on 2017/12/18/0018.
 */

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-18 11:17
 **/
public class MyFactoryBean implements FactoryBean<MyBean> {
    @Override
    public MyBean getObject() throws Exception {
        return new MyBean();
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
