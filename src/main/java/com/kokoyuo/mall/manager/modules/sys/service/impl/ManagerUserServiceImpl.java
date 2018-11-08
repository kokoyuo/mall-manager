package com.kokoyuo.mall.manager.modules.sys.service.impl;

import com.kokoyuo.mall.manager.shiro.ManagerUserInfo;
import com.kokoyuo.mall.manager.modules.sys.dao.ManagerUserRepository;
import com.kokoyuo.mall.manager.modules.sys.service.ManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kokoyuo
 * Created on 2018/10/26.
 */
@Service
public class ManagerUserServiceImpl implements ManagerUserService
{

    @Autowired
    private ManagerUserRepository managerUserRepository;

    @Override
    public ManagerUserInfo findByUsername(String userName) {
        return managerUserRepository.findByUserName(userName);
    }

    @Override
    public ManagerUserInfo save(ManagerUserInfo managerUserInfo)
    {
        return managerUserRepository.save(managerUserInfo);
    }

    @Override
    public Page<ManagerUserInfo> getManagerUserInfosPages(ManagerUserInfo managerUserInfo, Integer current_page, Integer page_size) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues()
                .withIgnorePaths("id");
        Example<ManagerUserInfo> example = Example.of(managerUserInfo,matcher);
        Pageable pageable = PageRequest.of(current_page,page_size, Sort.by(Sort.Direction.DESC,"createDate"));
        return managerUserRepository.findAll(example,pageable);
    }
}
