package com.group.ewaste.oauth.api.google;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class GoogleServiceProvider extends AbstractOAuth2ServiceProvider<Google> {
    private static final String AUTHORIZE_URL = "https://accounts.google.com/o/oauth2/v2/auth";
    private static final String ACCESS_TOKEN_URL = "https://www.googleapis.com/oauth2/v4/token";
    private final String clientId;
    public GoogleServiceProvider(String clientId, String clientSecret) {
        super(new GoogleAuth2Template(clientId, clientSecret, AUTHORIZE_URL, ACCESS_TOKEN_URL));
        this.clientId = clientId;
    }

    @Override
    public Google getApi(String accessToken) {
        return new GoogleImpl(accessToken);
    }
}
