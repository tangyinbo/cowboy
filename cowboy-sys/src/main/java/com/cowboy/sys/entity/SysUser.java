package com.cowboy.sys.entity;/**
 * Created by Administrator on 2017/12/14/0014.
 */

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @TableId(value = "user_id")
    private Long userId;
    @TableField(value = "user_name")
    private String userName;
    @TableField(value = "password")
    private String password;
    @TableField(value = "name")
    private String name;
    @TableField(value = "sex")
    private String sex;
    @TableField(value = "card_type")
    private String cardType;
    @TableField(value = "card_id")
    private String cardId;
    @TableField(value = "email")
    private String email;
    @TableField(value = "mobile_phone")
    private String mobilePhone;
    @TableField(value = "telephone")
    private String telephone;
    @TableField(value = "hobby")
    private String hobby;
    @TableField(value = "login_fail_count")
    private int loginFailCount;
    @TableField(value = "special_priv")
    private int specialPriv;

    private String stat;
    private Long crtuser;
    private Date crttime;
    private Long upduser;
    private Date updtime;
    private Integer version;

}
