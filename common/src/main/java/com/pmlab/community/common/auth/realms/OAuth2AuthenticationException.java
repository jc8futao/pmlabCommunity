package com.pmlab.community.common.auth.realms;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Oauth2授权异常
 * Created by tfu on 2016/3/24.
 */
public class OAuth2AuthenticationException extends AuthenticationException {
    public OAuth2AuthenticationException(Throwable cause) {
        super(cause);
    }
}
