package com.cowboy.web.config.cache.ehcache;/**
 * Created by Administrator on 2017/12/21/0021.
 */

import com.cowboy.sys.vo.SysUserVo;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;

import java.lang.reflect.Method;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-21 15:47
 **/
public class MyKeyGenerator implements KeyGenerator {
    private KeyGenerator defaultKeyGenerator = new SimpleKeyGenerator();
    @Override
    public Object generate(Object target, Method method, Object... params) {
        if(params != null && params.length ==1 && params[0] instanceof  SysUserVo){
            return "mykey_";
        }
        return defaultKeyGenerator.generate(target,method,params);
    }
}
