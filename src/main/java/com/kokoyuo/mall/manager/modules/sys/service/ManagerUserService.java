package com.kokoyuo.mall.manager.modules.sys.service;

import com.kokoyuo.mall.manager.shiro.ManagerUserInfo;
import org.springframework.data.domain.Page;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author kokoyuo
 * Created on 2018/10/26.
 */
public interface ManagerUserService
{
    /**findManagerUserInfoByUsername
     * @param userName
     * @return
     */
    ManagerUserInfo findByUsername(String userName);

    ManagerUserInfo save(ManagerUserInfo managerUserInfo);

    Page<ManagerUserInfo> getManagerUserInfosPages(ManagerUserInfo managerUserInfo,Integer current_page, Integer page_size);
}
