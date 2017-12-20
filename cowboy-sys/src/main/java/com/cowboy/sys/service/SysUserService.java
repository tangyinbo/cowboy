package com.cowboy.sys.service;/**
 * Created by Administrator on 2017/12/20/0020.
 */

import com.cowboy.comon.model.sys.CommonResponse;
import com.cowboy.comon.model.sys.PageResult;
import com.cowboy.sys.vo.SysUserVo;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-20 11:18
 **/
public interface SysUserService {
    /**
     * 新增用户
     * @param sysUserVo
     * @return
     */
    CommonResponse addUser(SysUserVo sysUserVo);

    /**
     * 查询用户分页信息
     * @param sysUserVo
     * @return
     */
    CommonResponse<PageResult<SysUserVo>> getUserList(SysUserVo sysUserVo);
}
