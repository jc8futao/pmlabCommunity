package com.pmlab.community.common.entity.auth.microChat;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 微信公众号认证Token
 */
public class OAuth2Token implements AuthenticationToken {

    public OAuth2Token(String authCode) {
        this.authCode = authCode;
    }

    private String authCode;
    private String principal;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @Override
    public Object getCredentials() {
        return authCode;
    }
}
