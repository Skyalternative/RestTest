package some.kind.of.framework.api;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import some.kind.of.framework.api.user.register.pojo.NewUser;
import some.kind.of.framework.data.CookiesWeaveSocks;
import some.kind.of.framework.data.LoginState;
import some.kind.of.framework.utils.ConfigHandler;
import some.kind.of.framework.utils.Configuration;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class ApiHandler {

    private final ConfigHandler configHandler;
    private final Api api;
    private LoginState loginState;
    private Cookies cookies;

    public ApiHandler(ConfigHandler configHandler, Api api) {
        this.configHandler = configHandler;
        this.api = api;

        // TODO should be extracted to separate component
        RestAssured.baseURI = this.configHandler.getValue(Configuration.BASE_URL);
        RestAssured.port = Integer.parseInt(this.configHandler.getValue(Configuration.BASE_PORT));
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
    }

    public void setLoginState(LoginState loginState) {
        this.loginState = loginState;
    }

    private RequestSpecification getRequestSpecification() {
        if (this.loginState == LoginState.LOGGED_OUT) {
            return given();
        }

        if (cookies == null || cookies.get(CookiesWeaveSocks.LOGGED_IN.getVal()).getExpiryDate().before(new Date())) {
            Response response = this.login();
            response.then().statusCode(HttpStatus.SC_OK);
            this.cookies = response.getDetailedCookies();
        }

        return given().cookies(this.cookies);
    }

    public Response login() {
        return this.login(this.configHandler.getValue(Configuration.USER_NAME), this.configHandler.getValue(Configuration.USER_PASSWORD));
    }

    public Response login(String username, String password) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(username);
        authScheme.setPassword(password);
        requestSpecBuilder.setAuth(authScheme);
        RequestSpecification requestSpecification = requestSpecBuilder.build();

        return given().spec(requestSpecification).when().get(this.api.getUser().getLogin()).then().extract().response();
    }

    public Response getAllCustomers() {
        return getRequestSpecification().when().get(this.api.getUser().getCustomers().getCustomers()).then().extract().response();
    }

    public Response getCustomer(String customerId) {
        return getRequestSpecification().when().get(this.api.getUser().getCustomers().getCustomer(customerId)).then().extract().response();
    }

    public Response registerNewUser(NewUser newUser) {
        return getRequestSpecification().contentType(ContentType.JSON).body(newUser).when().post(this.api.getUser().getRegister()).then().extract().response();
    }
}
