package com.cowboy.sys.shiro;/**
 * Created by Administrator on 2017/12/14/0014.
 */

import com.cowboy.comon.model.shiro.ShiroUser;
import com.cowboy.sys.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Tangyinbo22
 * @version 1.0
 * @create 2017-12-14 18:49
 **/
@Component
public class UserRealm extends AuthorizingRealm {
    @PostConstruct
    public void initRealm() {
        //todo 密码匹配
        setCredentialsMatcher(new CredentialsMatcher() {
            @Override
            public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
                String password = new String(((UsernamePasswordToken) authenticationToken).getPassword());
                //获得数据库中的密码
                String dbPassword = (String) authenticationInfo.getCredentials();
                return password.equals(dbPassword);
            }
        });
    }

    /**
     * 获取用户授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
        ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("admin");
        info.addStringPermission("/get/user");
        return info;
    }

    /**
     * 用户登录认证,并且获取用户认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //转换token类型
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //用户名
        String userName = usernamePasswordToken.getUsername();
        //数据库获取用户
        SysUser user = new SysUser();
        user.setLoginName("admin");
        user.setPassword("123456");
        //自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
        ShiroUser shiroUser = new ShiroUser();
        BeanUtils.copyProperties(user, shiroUser);
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword(), this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
}
