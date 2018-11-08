package com.kokoyuo.mall.manager.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kokoyuo.mall.manager.modules.sys.dao.ManagerUserRepository;
import com.kokoyuo.mall.manager.modules.sys.service.ManagerUserService;
import com.kokoyuo.mall.manager.shiro.ManagerUserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kokoyuo
 * Created on 2018/11/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerUserServiceImplTest {

    @Autowired
    private ManagerUserService managerUserService;

    @Autowired
    private ManagerUserRepository managerUserRepository;

    @Test
    public void getManagerUserInfosPages() {
        ManagerUserInfo userInfo = new ManagerUserInfo();
        userInfo.setUserName("kokoyuo");
        //userInfo.setRemark("111");

        Pageable pageable = PageRequest.of(0,10); //, Sort.by(Sort.Direction.DESC,"")
/*        ExampleMatcher matcher = ExampleMatcher.matching()
                //.withMatcher("userName", match -> match.startsWith())
                .withIgnoreNullValues()
                .withIgnorePaths("id");*/


        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnorePaths("id");

        Example example = Example.of(userInfo,matcher);

        Page<ManagerUserInfo> userInfoPage = managerUserRepository.findAll(example,pageable);
        List<ManagerUserInfo> userInfos = userInfoPage.getContent();
        System.out.println(JSONObject.toJSONString(userInfoPage));

        System.out.println(JSONObject.toJSONString(userInfos));
    }


}