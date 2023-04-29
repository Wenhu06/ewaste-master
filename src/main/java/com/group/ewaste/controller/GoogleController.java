package com.group.ewaste.controller;

import com.group.ewaste.oauth.GoogleAuthorizationService;
import com.group.ewaste.oauth.api.google.GoogleImpl;
import com.group.ewaste.oauth.api.google.GoogleUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

@Api("/thirdparty")
@RestController
@RequestMapping("/thirdparty")
public class GoogleController {
    @Autowired
    private GoogleAuthorizationService googleAuthorizationService;

    @ApiOperation(value = "", notes = "跳转谷歌登录页面", httpMethod = "GET")
    @GetMapping("/google")
    public String googleLogin() throws GeneralSecurityException, IOException {
        String authorizationUrl = googleAuthorizationService.getAuthorizationUrl();
        return "redirect:" + authorizationUrl;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "authorizationCode", value = "从谷歌返回的授权码", required = true)
    })
    @ApiOperation(value = "", notes = "用户登陆成功，获取到用户的登录信息", httpMethod = "GET")
    @GetMapping("/google/login")
    public Map<String, Object> googleLogin(@RequestParam("code") String authorizationCode) throws GeneralSecurityException, IOException {
        String googleAccessToken = googleAuthorizationService.authorizing(authorizationCode);
        GoogleImpl google = new GoogleImpl(googleAccessToken);
        GoogleUserInfo userInfo = google.getUserInfo();

        Map<String, Object> userInfoMap = new HashMap<>();
        userInfoMap.put("sub", userInfo.getId());
        userInfoMap.put("email", userInfo.getEmail());
        userInfoMap.put("name", userInfo.getName());
        userInfoMap.put("given_name", userInfo.getGiven_name());
        userInfoMap.put("family_name", userInfo.getFamily_name());
        userInfoMap.put("picture", userInfo.getPicture());
        userInfoMap.put("locale", userInfo.getLocale());
        userInfoMap.put("hd", userInfo.getHd());

        return userInfoMap;
    }
}

