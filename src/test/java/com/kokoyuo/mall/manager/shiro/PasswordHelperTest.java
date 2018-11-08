package com.kokoyuo.mall.manager.shiro;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kokoyuo
 * Created on 2018/10/29.
 */
public class PasswordHelperTest {

    @Test
    public void encryptPassword() {
        PasswordHelper ph = new PasswordHelper();
        String name = "kokoyuo";
        String pwd = "123456";
        System.out.println(ph.encryptPassword(pwd,null));
    }


}