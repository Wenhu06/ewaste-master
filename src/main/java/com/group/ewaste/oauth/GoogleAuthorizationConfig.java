package com.group.ewaste.oauth;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * google登录授权配置
 */
@Configuration
@Slf4j
public class GoogleAuthorizationConfig {
    private static final String clientId = "761474755392-a71uisqkpupu72d1h4h27uah9fidm1k0.apps.googleusercontent.com";
    private static final  String clientSecret = "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";
    private static final  String applicationName = "eWaste";
    private static final  String redirectUrl = "http://localhost:8088/uac/google/login";
    @Bean(name = "googleAuthorization")
    public GoogleAuthorization googleFeed() {
        GoogleClientSecrets clientSecrets = null;
        try {
            GoogleClientSecrets.Details details = new GoogleClientSecrets.Details();
            details.setClientId(clientId);
            details.setClientSecret(clientSecret);
            clientSecrets = new GoogleClientSecrets();
            clientSecrets.setInstalled(details);
        } catch (Exception e) {
            log.error("authorization configuration error:{}", e.getMessage());
        }

        return GoogleAuthorization.builder()
                .googleClientSecrets(clientSecrets)
                .applicationName(applicationName)
                .redirectUrl(redirectUrl)
                .build();
    }

}
