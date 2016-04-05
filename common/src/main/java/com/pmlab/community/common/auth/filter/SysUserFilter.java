package com.pmlab.community.common.auth.filter;

import com.pmlab.community.common.entity.user.User;
import com.pmlab.community.common.service.BaseUserService;
import com.pmlab.community.common.web.Constants;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 微信用户 Filter：当通过微信授权登录时，判断用户是否为系统注册用户，如果不是，则引导用户进入注册页面
 */
public class SysUserFilter extends AccessControlFilter {
    @Autowired
    private BaseUserService baseUserService;

    /**
     * 是否为Oauth2授权
     */
    private Boolean ifOauth2 = false;

    /**
     * 用户注册重定向的地址
     */
    private String userNotfoundUrl;

    /**
     * 用户锁定后重定向的地址
     */
    private String userBlockedUrl;
    /**
     * 未知错误
     */
    private String userUnknownErrorUrl;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        if (subject == null) {
            return true;
        }

        String username = (String) subject.getPrincipal();
        //此处注意缓存 防止大量的查询db
        User user = null;
        if(ifOauth2){
            user = baseUserService.findByOpenId(username);
        }else{
            user = baseUserService.findByUsername(username);
        }
        if(user == null){
            return false;
        }
        //把当前用户放到session中
        request.setAttribute(Constants.CURRENT_USER, user);
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (!ifOauth2){
            getSubject(request, response).logout();
        }
        saveRequestAndRedirectToLogin(request, response);
        return true;
    }

    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        if (!ifOauth2){
            getSubject(request, response).logout();
        }
        WebUtils.issueRedirect(request, response, userNotfoundUrl);
    }

    public void setIfOauth2(Boolean ifOauth2) {
        this.ifOauth2 = ifOauth2;
    }

    public void setUserNotfoundUrl(String userNotfoundUrl) {
        this.userNotfoundUrl = userNotfoundUrl;
    }

    public void setUserBlockedUrl(String userBlockedUrl) {
        this.userBlockedUrl = userBlockedUrl;
    }

    public void setUserUnknownErrorUrl(String userUnknownErrorUrl) {
        this.userUnknownErrorUrl = userUnknownErrorUrl;
    }
}
