package com.kokoyuo.mall.manager.shiro;

import com.kokoyuo.mall.manager.modules.sys.service.ManagerUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author kokoyuo
 * Created on 2018/10/24.
 */
@Component
public class ManagerRealm extends AuthorizingRealm {

    @Autowired
    private ManagerUserService managerUserService;

    @Autowired
    private HashedCredentialsMatcher hashedCredentialsMatcher;

    @PostConstruct
    void initCredentialsMatcher()
    {
        this.setCredentialsMatcher(hashedCredentialsMatcher);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*获取主要的身份*/
        String userName = (String) principalCollection.getPrimaryPrincipal();

        /*暂时不添加权限*/
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken tk = (UsernamePasswordToken) authenticationToken;
        /*获取用户身份 username */
        String username = (String) tk.getPrincipal();
        /*获取用户信息*/
        ManagerUserInfo managerUserInfo = managerUserService.findByUsername(username);

        /*获取凭据 - pwd*/
        String pwd = new String((char[]) tk.getCredentials());

        /*验证pwd 是否正确*/
        //todo
        if(true)
        {
            return new SimpleAuthenticationInfo(managerUserInfo.getUserName(),managerUserInfo.getUserPwd(),getName());
        }


        throw new UnknownAccountException();
    }
}
