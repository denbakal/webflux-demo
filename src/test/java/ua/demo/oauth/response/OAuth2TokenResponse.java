package ua.demo.oauth.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuth2TokenResponse {
    private String access_token;
    private String token_type;
    private long expires_in;
    private String scope;
    private String refresh_token;
}
