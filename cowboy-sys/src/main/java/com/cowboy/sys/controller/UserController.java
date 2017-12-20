package com.cowboy.sys.controller;/**
 * Created by Administrator on 2017/12/20/0020.
 */

import com.cowboy.comon.model.sys.CommonResponse;
import com.cowboy.comon.model.sys.PageResult;
import com.cowboy.sys.service.SysUserService;
import com.cowboy.sys.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-20 11:13
 **/
@RestController
@RequestMapping("/sysUser")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 新增或者修改用户
     * @param sysUserVo 用户值对象
     * @return
     */
    @RequestMapping("/saveUser")
    public CommonResponse saveUser(@RequestBody SysUserVo sysUserVo){
        Long userId = sysUserVo.getUserId();
        CommonResponse response = null;
        //新增
        if(userId == null){
            //保存用户
            response = addUser(sysUserVo);
        }else{
            //修改
            response = updateUser(sysUserVo);
        }
        return response;
    }

    @RequestMapping("/getUserList")
    public CommonResponse<PageResult<SysUserVo>> getUserList(@RequestBody SysUserVo sysUserVo){
        return sysUserService.getUserList(sysUserVo);
    }
    /**
     * 修改用户
     * @param sysUserVo
     * @return
     */
    private CommonResponse updateUser(SysUserVo sysUserVo) {
        return null;
    }

    /**
     * 新增用户
     * @param sysUserVo
     * @return
     */
    private CommonResponse addUser(SysUserVo sysUserVo) {
        return sysUserService.addUser(sysUserVo);
    }
}
