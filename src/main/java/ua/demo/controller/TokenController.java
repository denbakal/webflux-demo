package ua.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private TokenStore tokenStore;

    @GetMapping("/revoke")
    public void revoke(OAuth2Authentication authentication) {
        OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails) authentication.getDetails();
        OAuth2AccessToken accessToken = this.tokenStore.readAccessToken(authenticationDetails.getTokenValue());
        String jti = (String) accessToken.getAdditionalInformation().get("jti");
        this.redisTemplate.opsForValue().getOperations().delete(jti);
    }
}
