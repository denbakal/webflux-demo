package ua.demo.oauth.grant;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;
import org.junit.Test;
import ua.demo.oauth.OAuthBaseTest;
import ua.demo.oauth.response.OAuth2TokenResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordGrantTest extends OAuthBaseTest {
    @Test
    @SneakyThrows
    public void postWithBasic() {
        HttpResponse<OAuth2TokenResponse> response = Unirest.post(APPLICATION_HOST + "/oauth/token")
                .basicAuth(CLIENT_PASSWORD_CODE_ID, SECRET)
                .field("grant_type", "password")
                .field("username", "admin")
                .field("password", "admin")
                .asObject(OAuth2TokenResponse.class);

        OAuth2TokenResponse auth2Response = response.getBody();
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(auth2Response.getAccess_token()).isNotEmpty();
        assertThat(auth2Response.getToken_type()).isEqualTo("bearer");
        assertThat(auth2Response.getRefresh_token()).isNotEmpty();
        assertThat(auth2Response.getExpires_in()).isNotZero();
        assertThat(auth2Response.getScope()).isEqualTo("read");
    }
}
