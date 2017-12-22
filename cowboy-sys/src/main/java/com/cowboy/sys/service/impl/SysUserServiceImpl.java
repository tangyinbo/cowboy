package com.cowboy.sys.service.impl;/**
 * Created by Administrator on 2017/12/20/0020.
 */

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cowboy.comon.model.sys.CommonResponse;
import com.cowboy.comon.model.sys.PageResult;
import com.cowboy.sys.entity.SysUser;
import com.cowboy.sys.mapper.SysUserMapper;
import com.cowboy.sys.service.SysUserService;
import com.cowboy.sys.vo.SysUserVo;
import com.cowboy.utils.CBeanUtils;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-20 11:19
 **/
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    @CacheEvict(value = "cowoy_sys_user",keyGenerator = "myKeyGenerator" )
    public CommonResponse addUser(SysUserVo sysUserVo) {
        log.info("==============adduser================");
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserVo,sysUser);
        sysUserMapper.insert(sysUser);
        return CommonResponse.buildSuccessResult();
    }

    @Override
    @Cacheable(value = "cowoy_sys_user",keyGenerator = "myKeyGenerator" )
    public CommonResponse<PageResult<SysUserVo>> getUserList(SysUserVo sysUserVo) {
        Wrapper<SysUser> wrapper = new EntityWrapper<>();
        List<SysUser> userLists = sysUserMapper.selectList(wrapper);

        PageResult<SysUserVo> pageResult = new PageResult<>();
        List<SysUserVo> results = CBeanUtils.mapList(userLists,SysUserVo.class);
        pageResult.setRows(results);
        return CommonResponse.buildSuccessResult(pageResult);
    }
}
