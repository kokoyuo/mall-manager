package com.kokoyuo.mall.manager.modules.sys.dao;

import com.kokoyuo.mall.manager.shiro.ManagerUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kokoyuo
 * Created on 2018/10/26.
 */
public interface ManagerUserRepository extends JpaRepository<ManagerUserInfo,Integer>
{
    ManagerUserInfo findByUserName(String userName);
}
