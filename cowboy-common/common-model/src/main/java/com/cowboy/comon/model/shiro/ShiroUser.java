package com.cowboy.comon.model.shiro;/**
 * Created by Administrator on 2017/12/14/0014.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-14 19:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiroUser implements Serializable {
    private Integer userId;
    private String userName;
    private String name;
    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString(){
        return userName;
    }
    /**
     * 重载hashCode,只计算loginName;
     */
    @Override
    public int hashCode(){
        return Objects.hashCode(userName);
    }
    /**
     * 重载equals,只计算userName
     */
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        ShiroUser other=(ShiroUser)obj;
        if(userName==null){
            if(other.getUserName()!=null){
                return false;
            }
        }else if(!userName.equals(other.getUserName())){
            return false;
        }
        return true;
    }
}