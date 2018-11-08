package ua.demo.config.oauth.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.rmi.NoSuchObjectException;
import java.util.concurrent.TimeUnit;

public class CustomTokenServices extends DefaultTokenServices {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) throws AuthenticationException {
        OAuth2AccessToken token = super.createAccessToken(authentication);
        String jti = (String) token.getAdditionalInformation().get("jti");

        this.redisTemplate.opsForValue().set(jti, token.getValue());
        this.redisTemplate.expire(jti, 10, TimeUnit.MINUTES);

        return token;
    }

    @Override
    public OAuth2AccessToken refreshAccessToken(String refreshTokenValue, TokenRequest tokenRequest) throws AuthenticationException {
        OAuth2AccessToken token = super.refreshAccessToken(refreshTokenValue, tokenRequest);
        return token;
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessTokenValue) throws AuthenticationException, InvalidTokenException {
        OAuth2AccessToken currentAccessToken = this.tokenStore.readAccessToken(accessTokenValue);
        String jti = (String) currentAccessToken.getAdditionalInformation().get("jti");
        String result = this.redisTemplate.opsForValue().get(jti);

        if (result == null) {
            throw new InvalidTokenException(jti);
        }

        return super.loadAuthentication(accessTokenValue);
    }
}
