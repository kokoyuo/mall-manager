package com.kokoyuo.mall.manager.shiro;

import com.kokoyuo.mall.manager.Swagger2;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.stereotype.Component;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * 自定义sessionId获取
 * @author kokoyuo
 * Created on 2018/10/26.
 */
@Component
public class MySessionManager extends DefaultWebSessionManager
{

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public MySessionManager(RedisSessionDAO redisSessionDAO)
    {
        super();
        this.setSessionDAO(redisSessionDAO);
    }


    /**
     * 自定义sessionId获取
     * @param request
     * @param response
     * @return
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response)
    {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        String token = httpServletRequest.getHeader(Swagger2.TOKEN_HEAD);
        if(StringUtils.isNotBlank(token))
        {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return token;
        }else
        {
            return super.getSessionId(request, response);
        }

    }


}
