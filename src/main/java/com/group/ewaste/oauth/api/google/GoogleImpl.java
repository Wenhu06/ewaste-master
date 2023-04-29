package com.group.ewaste.oauth.api.google;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

public class GoogleImpl extends AbstractOAuth2ApiBinding implements Google {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public final static String URL_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json";

    private ObjectMapper objectMapper = new ObjectMapper();

    public GoogleImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
    }

    @Override
    public GoogleUserInfo getUserInfo() {
        String result = getRestTemplate().getForObject(URL_GET_USER_INFO, String.class);
        logger.info(result);
        GoogleUserInfo googleUserInfo;
        try {
            googleUserInfo = objectMapper.readValue(result, GoogleUserInfo.class);
        } catch (IOException e) {
            throw new RuntimeException("获取Google用户信息失败", e);
        }
        return googleUserInfo;
    }
}
