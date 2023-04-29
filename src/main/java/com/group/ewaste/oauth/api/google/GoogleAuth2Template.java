package com.group.ewaste.oauth.api.google;

import com.alibaba.fastjson.JSON;
import com.google.api.client.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class GoogleAuth2Template extends OAuth2Template {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public GoogleAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = super.createRestTemplate();
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }

    // Google 授权服务器返回的是 json 格式的字符串，因此需要修改此方法来处理返回的字符串
    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(String.valueOf(MediaType.APPLICATION_FORM_URLENCODED));
        String responseStr = getRestTemplate().exchange(accessTokenUrl, HttpMethod.POST, new HttpEntity<>(headers,parameters), String.class).getBody();
        logger.debug("获取 accessToken 响应: {}", responseStr);
        Map<String, Object> result = new HashMap<>();
        result = JSON.parseObject(responseStr, result.getClass());
        String accessToken = (String) result.get("access_token");
        Integer expiresIn = (Integer) result.get("expires_in");
        String refreshToken = (String) result.get("refresh_token");
        return new AccessGrant(accessToken, null, refreshToken, expiresIn.longValue());
    }
}
