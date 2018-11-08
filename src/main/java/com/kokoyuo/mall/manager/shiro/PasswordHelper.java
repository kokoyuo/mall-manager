package com.kokoyuo.mall.manager.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;

/**
 * @author kokoyuo
 * Created on 2018/10/29.
 */
@Component
public class PasswordHelper {

    private static final String algorithmName = "md5";

    private static final int hashIterations = 2;

    public ManagerUserInfo encryptPassword(ManagerUserInfo userInfo)
    {
        String pwd = new SimpleHash(algorithmName,userInfo.getUserPwd(),null,hashIterations).toHex();
        userInfo.setUserPwd(pwd);
        return userInfo;
    }

    public String encryptPassword(String beforePwd,String salt)
    {
        String afterPwd = new SimpleHash(algorithmName,beforePwd,salt,hashIterations).toHex();
        return afterPwd;
    }
}
