package com.pmlab.community.common.service.microChat;

import com.pmlab.community.common.cache.CacheContents;
import com.pmlab.community.common.entity.auth.microChat.AccessToken;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.shiro.authz.AuthorizationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * 微信操作接口
 */
@Service
public class MicroChatService {
    private byte[] locker = new byte[0];

    @Value("#{interfaces['officialAccount.accessTokenUrl']}")
    private String accessTokenUrl;

    @Value("#{interfaces['officialAccount.accessRefreshTokenUrl']}")
    private String accessRefreshTokenUrl;

    @Value("#{interfaces['officialAccount.clientId']}")
    private String clientId;

    @Value("#{interfaces['officialAccount.clientSecret']}")
    private String clientSecret;

    private ObjectMapper objectMapper = new ObjectMapper();

    public AccessToken getAccessTokenByCode(String code) throws AuthorizationException {
        AccessToken accessToken = null;
        String requestUrl = String.format(accessTokenUrl, clientId, clientSecret, code);
        WebClient client = WebClient.create(requestUrl);
        try {
            Response response = client.get();
            String jsonString = response.readEntity(String.class);
            accessToken = objectMapper.readValue(jsonString, AccessToken.class);
            accessToken.setTimestamp(new Date());
        }catch (Exception e){
            throw new AuthorizationException(e);
        }

        return accessToken;
    }

    public AccessToken refreshAccessToken(AccessToken accessToken){
        String requestUrl = String.format(accessRefreshTokenUrl, clientId, accessToken.getRefresh_token());
        WebClient client = WebClient.create(requestUrl);
        try {
            Response response = client.get();
            String jsonString = response.readEntity(String.class);
            AccessToken accessRefreshToken = objectMapper.readValue(jsonString, AccessToken.class);

            accessToken.setAccess_token(accessRefreshToken.getAccess_token());
            accessToken.setExpires_in(accessRefreshToken.getExpires_in());
            accessToken.setRefresh_token(accessRefreshToken.getRefresh_token());
            accessRefreshToken.setTimestamp(new Date());
        }catch (Exception e){
            throw new AuthorizationException(e);
        }

        return accessToken;
    }
}
