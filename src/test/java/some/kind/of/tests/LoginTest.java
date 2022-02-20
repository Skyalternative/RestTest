package some.kind.of.tests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import some.kind.of.framework.api.ApiHandler;
import some.kind.of.framework.utils.ConfigHandler;
import some.kind.of.framework.utils.Configuration;
import some.kind.of.framework.utils.Login;
import some.kind.of.framework.utils.TestFactory;

@Tag("Login")
class LoginTest {

    private ApiHandler api;
    private ConfigHandler configHandler;

    @BeforeEach
    public void setUp() {
        api = new TestFactory().getApi(Login.LOGGED_OUT);
        configHandler = new ConfigHandler();
    }

    @Test
    @DisplayName("Positive login Test")
    @Tag("Positive")
    void loginTestPositive() {
        Response loginResponse = api.login();
        loginResponse.then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("Negative login Test")
    @Tag("Negative")
    void loginTestNegative() {
        Response loginResponse = api.login(
                configHandler.getValue(Configuration.INVALID_USER_NAME),
                configHandler.getValue(Configuration.INVALID_USER_PASSWORD)
        );
        loginResponse.then().statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

}
