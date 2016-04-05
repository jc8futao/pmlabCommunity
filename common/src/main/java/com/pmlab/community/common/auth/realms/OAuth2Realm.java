package com.pmlab.community.common.auth.realms;

import com.pmlab.community.common.entity.auth.microChat.AccessToken;
import com.pmlab.community.common.entity.auth.microChat.OAuth2Token;
import com.pmlab.community.common.entity.user.User;
import com.pmlab.community.common.service.BaseAuthService;
import com.pmlab.community.common.service.BaseUserService;
import com.pmlab.community.common.service.microChat.MicroChatService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * OAuth2Realm 授权的主体为 Access token
 */
public class OAuth2Realm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(OAuth2Realm.class);

    @Inject
    private MicroChatService microChatService;

    @Inject
    private BaseUserService baseUserService;
    @Inject
    private BaseAuthService baseAuthService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;//表示此Realm只支持OAuth2Token类型
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //get roles and resources
        String username = (String)principals.getPrimaryPrincipal();
        User user = baseUserService.findByUsername(username);

        if(user == null){
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.setRoles(baseAuthService.findStringRoles(user));
            authorizationInfo.setStringPermissions(baseAuthService.findStringPermissions(user));
            return authorizationInfo;
        }else {
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            return authorizationInfo;
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        OAuth2Token oAuth2Token = (OAuth2Token) token;
        String code = oAuth2Token.getAuthCode();
        String username = extractUsername(code);

        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(username, code, getName());
        return authenticationInfo;
    }

    private String extractUsername(String code) {

        try {
            AccessToken accessToken = microChatService.getAccessTokenByCode(code);
            String username = accessToken.getOpenid();
            logger.info("Authentication code:" + code);
            return username;
        } catch (Exception e) {
            e.printStackTrace();
            throw new OAuth2AuthenticationException(e);
        }
    }
}
