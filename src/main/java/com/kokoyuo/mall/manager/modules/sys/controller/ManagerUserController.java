package com.kokoyuo.mall.manager.modules.sys.controller;

import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import com.kokoyuo.mall.manager.modules.sys.service.ManagerUserService;
import com.kokoyuo.mall.manager.shiro.ManagerUserInfo;
import com.kokoyuo.mall.manager.shiro.PasswordHelper;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * @author kokoyuo
 * Created on 2018/11/1.
 */
@Api(value = "用户管理接口",description = "用户管理接口")
@RequestMapping("/manageruser")
@RestController
public class ManagerUserController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerUserController.class);

    @Autowired
    private ManagerUserService managerUserService;

    @Autowired
    private PasswordHelper passwordHelper;

    @ApiOperation(value = "获取登录用户信息")
    @GetMapping("")
    public Result get()
    {
        Subject subject = SecurityUtils.getSubject();
        /*获取用户身份 username */

        String username = (String) subject.getPrincipal();
        /*获取用户信息*/
        ManagerUserInfo managerUserInfo = managerUserService.findByUsername(username);
        return Result.getDefaultSuccessResult(managerUserInfo);
    }

    @ApiOperation(value = "更新用户",notes = "当userInfo[id]为空是为新增、否则更新")
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public Result alter(@ApiParam(value = "新增用户信息") @RequestBody ManagerUserInfo userInfo)
    {
        passwordHelper.encryptPassword(userInfo);
        managerUserService.save(userInfo);
        return Result.SUCCESS_INSTANCE;
    }

    @ApiOperation(value = "获取用户列表信息",notes = "获取用户列表信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "current_page",paramType = "path",value = "当前页",dataType = "Integer"),
                    @ApiImplicitParam(name = "page_size",paramType = "path",value = "页面大小",dataType = "Integer"),
                    @ApiImplicitParam(name = "userName",paramType = "query",value = "用户名",dataType = "String"),
                    @ApiImplicitParam(name = "userCode",paramType = "query",value = "user code",dataType = "String"),
            })
    @GetMapping("/{current_page}/{page_size}")
    public Result getUserList(@PathVariable Integer current_page,@PathVariable Integer page_size,
                              @RequestParam(required = false) String userName,@RequestParam(required = false) String userCode)
    {
        ManagerUserInfo userInfo = new ManagerUserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserCode(userCode);
        return Result.getDefaultSuccessResult(managerUserService.getManagerUserInfosPages(userInfo,current_page,page_size));
    }
}
