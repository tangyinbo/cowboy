package com.cowboy.sys.entity;/**
 * Created by Administrator on 2017/12/14/0014.
 */

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-14 14:21
 **/
@TableName(value = "t_sys_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    @TableField(value = "user_id")
    private Integer userId;
    @TableField(value = "login_name")
    private String loginName;
    @TableField(value = "password")
    private String password;
    @TableField(value = "name")
    private String name;

}
