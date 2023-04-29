package com.group.ewaste.oauth;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class GoogleAuthorizationService {

    private final GoogleAuthorization googleAuthorization;

    @Autowired
    public GoogleAuthorizationService(GoogleAuthorization googleAuthorization) {
        this.googleAuthorization = googleAuthorization;
    }

    public String getAuthorizationUrl() throws GeneralSecurityException, IOException {
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow = new GoogleAuthorizationCodeFlow
                .Builder(httpTransport, jsonFactory, googleAuthorization.getGoogleClientSecrets(), googleAuthorization.getScopes())
                .setAccessType("offline").build();
        return googleAuthorizationCodeFlow.newAuthorizationUrl().setRedirectUri(googleAuthorization.getRedirectUrl()).build();
    }

    public String authorizing(String authorizationCode) throws GeneralSecurityException, IOException {
        // 创建请求凭证
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        GoogleAuthorizationCodeFlow googleAuthorizationCodeFlow = new GoogleAuthorizationCodeFlow
                .Builder(httpTransport, jsonFactory, googleAuthorization.getGoogleClientSecrets(), googleAuthorization.getScopes())
                .setAccessType("offline").build();
        GoogleAuthorizationCodeTokenRequest tokenRequest = googleAuthorizationCodeFlow.newTokenRequest(authorizationCode);
        tokenRequest.setRedirectUri(googleAuthorization.getRedirectUrl());
        // 发起授权请求，获得Token和Refresh Token
        GoogleTokenResponse tokenResponse = tokenRequest.execute();
        String refreshToken = tokenResponse.getRefreshToken();
        String token = tokenResponse.getAccessToken();
        // 获得email
        String email = null;

        if (StringUtils.isNotBlank(tokenResponse.getIdToken())) {
            GoogleIdTokenVerifier idTokenVerifier = new GoogleIdTokenVerifier.Builder(googleAuthorizationCodeFlow.getTransport(), jsonFactory)
                    .setAudience(Collections.singletonList(googleAuthorization.getGoogleClientSecrets().getDetails().getClientId()))
                    .build();
            GoogleIdToken googleIdToken = idTokenVerifier.verify(tokenResponse.getIdToken());
            if (googleIdToken != null && googleIdToken.getPayload() != null) {
                email = googleIdToken.getPayload().getEmail();
            }
        }
        return token;
    }

}
