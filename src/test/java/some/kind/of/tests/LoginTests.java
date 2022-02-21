package some.kind.of.tests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import some.kind.of.framework.api.ApiHandler;
import some.kind.of.framework.data.CookiesWeaveSocks;
import some.kind.of.framework.data.LoginState;
import some.kind.of.framework.utils.ConfigHandler;
import some.kind.of.framework.utils.Configuration;
import some.kind.of.framework.utils.TestFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@Tag("Login")
class LoginTests {

    private ApiHandler api;
    private ConfigHandler configHandler;

    @BeforeEach
    public void setUp() {
        api = new TestFactory().getApi(LoginState.LOGGED_OUT);
        configHandler = new ConfigHandler();
    }

    @Test
    @DisplayName("Should be able to login with correct credentials")
    @Tag("Positive")
    void authorizationTest() {
        Response response = api.login();

        response.then().statusCode(HttpStatus.SC_OK);
        assertNotNull(response.getDetailedCookie(CookiesWeaveSocks.LOGGED_IN.getVal()));
    }

    @Test
    @DisplayName("Shouldn't be able to login with invalid credentials")
    @Tag("Negative")
    void negativeAuthorizationTest() {
        Response response = api.login(
                configHandler.getValue(Configuration.INVALID_USER_NAME),
                configHandler.getValue(Configuration.INVALID_USER_PASSWORD)
        );
        response.then().statusCode(HttpStatus.SC_UNAUTHORIZED);
        assertNull(response.getDetailedCookie(CookiesWeaveSocks.LOGGED_IN.getVal()));
    }
}
