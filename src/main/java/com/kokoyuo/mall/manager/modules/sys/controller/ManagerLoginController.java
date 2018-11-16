package com.kokoyuo.mall.manager.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.kokoyuo.mall.manager.Swagger2;
import com.kokoyuo.mall.manager.shiro.ManagerUserInfo;
import com.kokoyuo.mall.manager.modules.sys.pojo.Result;
import com.kokoyuo.mall.manager.modules.sys.pojo.Status;
import com.kokoyuo.mall.manager.modules.sys.service.ManagerUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author kokoyuo
 * Created on 2018/10/26.
 */
@Api(value = "后台用户登录接口",description = "后台用户登录接口")
@RequestMapping("/")
@RestController("mallManagerLoginController")
public class ManagerLoginController
{

    @Autowired
    private ManagerUserService managerUserService;

    @ApiOperation(value = "用户登录",notes = "后台用户登录")
    @ApiImplicitParam(name = "jsonObj",value = "RequestBody[user_name,password]",paramType = "body",example = "{\"user_name\":\"kokoyuo\",\"password\":\"123456\"}",required = true)
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result login(@RequestBody JSONObject jsonObj)
    {
        String userName = (String) jsonObj.get("user_name");
        String password = (String) jsonObj.get("password");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        UsernamePasswordToken upt = new UsernamePasswordToken(userName,password);
        try {
            subject.login(upt);
        }catch (Exception e)
        {
            return new Result(new Status(500,e.getMessage()));
        }
        String token = (String) subject.getSession().getId();
        ManagerUserInfo managerUserInfo = managerUserService.findByUsername(userName);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("userPwd");
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(managerUserInfo,filter));
        jsonObject.put(Swagger2.TOKEN_HEAD,token);
        return new Result(new Status(Status.RETURN_TYPE.SUCCESS),jsonObject);
    }

    @ApiOperation(value = "退出登录",notes = "后台用户退出登录")
    @ApiImplicitParam(name = Swagger2.TOKEN_HEAD,value = "token",paramType = "header",required = true)
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public Result logout()
    {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.SUCCESS_INSTANCE;
    }

    @ApiOperation(value = "登录状态测试接口")
    @RequestMapping(value = "test/test",method = RequestMethod.POST)
    public String test()
    {
        return "test/test";
    }

    @ApiIgnore
    @RequestMapping("unauth")
    public String unauth()
    {
        return "unauth";
    }
}
