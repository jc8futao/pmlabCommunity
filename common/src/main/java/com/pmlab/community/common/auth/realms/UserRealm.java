package com.pmlab.community.common.auth.realms;

import com.pmlab.community.common.entity.auth.Auth;
import com.pmlab.community.common.entity.user.User;
import com.pmlab.community.common.service.BaseAuthService;
import com.pmlab.community.common.service.BaseUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tao on 2014/12/2.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private BaseUserService baseUserService;
    @Autowired
    private BaseAuthService baseAuthService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;//表示此Realm只支持OAuth2Token类型
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        User user = baseUserService.findByUsername(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Auth m = baseAuthService.getAuthOfUser(user);
        authorizationInfo.setRoles(m.getRoleStrings());
        authorizationInfo.setStringPermissions(m.getPermissionStrings());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();

        User user = baseUserService.findByUsername(username);

        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if (Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //auth name
        );
        return authenticationInfo;
    }
}
