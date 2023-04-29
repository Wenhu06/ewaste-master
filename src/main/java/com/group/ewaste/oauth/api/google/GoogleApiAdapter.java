package com.group.ewaste.oauth.api.google;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class GoogleApiAdapter implements ApiAdapter<Google> {

    @Override
    public boolean test(Google api) {
        try {
            api.getUserInfo();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Google api, ConnectionValues values) {
        GoogleUserInfo userInfo = api.getUserInfo();
        values.setDisplayName(userInfo.getName());
        values.setImageUrl(userInfo.getPicture());
        values.setProfileUrl(null);
        values.setProviderUserId(userInfo.getId());
    }

    @Override
    public UserProfile fetchUserProfile(Google api) {
        return UserProfile.EMPTY;
    }

    @Override
    public void updateStatus(Google api, String message) {
        // do nothing
    }
}