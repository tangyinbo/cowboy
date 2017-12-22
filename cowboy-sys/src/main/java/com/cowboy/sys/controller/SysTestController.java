package com.cowboy.sys.controller;

import com.cowboy.comon.model.sys.CommonResponse;
import com.cowboy.log.annotation.RequestParamResultLogPrint;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.event.CacheManagerEventListener;
import net.sf.ehcache.event.CacheManagerEventListenerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cowboy on 2017-12-16.
 */
@Controller
public class SysTestController {
    @RequestMapping("/sys")
    @RequestParamResultLogPrint
    public String sys(){
        return "sys";
    }
    @RequestMapping("/sys2")
    @RequestParamResultLogPrint
    public String sys2(){
        return "sys2";
    }

    /**
     * 获取ehcache 统计信息
     * @return
     */
    @RequestMapping("/ehCacheStatistics")
    @ResponseBody
    public CommonResponse getEhcacheStatistics(){
        //缓存管理器
        CacheManager cacheManager = CacheManager.getInstance();
        Cache cache = cacheManager.getCache("cowoy_sys_user");
        List result =cache.getKeys();
        return CommonResponse.buildSuccessResult(result);
    }
}
