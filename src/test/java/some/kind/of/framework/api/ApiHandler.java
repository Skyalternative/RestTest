package some.kind.of.framework.api;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import some.kind.of.framework.utils.ConfigHandler;
import some.kind.of.framework.utils.Configuration;

import static io.restassured.RestAssured.given;

public class ApiHandler {

    private final ConfigHandler configHandler;
    private final Api api;

    public ApiHandler(ConfigHandler configHandler, Api api) {
        this.configHandler = configHandler;
        this.api = api;

        // TODO extract to more decent place
        RestAssured.baseURI = this.configHandler.getValue(Configuration.BASE_URL);
        RestAssured.port = Integer.parseInt(this.configHandler.getValue(Configuration.BASE_PORT));
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
    }

    public Response login() {
        return this.login(
                this.configHandler.getValue(Configuration.USER_NAME),
                this.configHandler.getValue(Configuration.USER_PASSWORD)
        );
    }

    public Response login(String username, String password) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(username);
        authScheme.setPassword(password);
        requestSpecBuilder.setAuth(authScheme);
        RequestSpecification requestSpecification = requestSpecBuilder.build();

        return given()
                .spec(requestSpecification)
                .get(this.api.getApiUsers().getLogin())
                .then()
                .extract().response();
    }

}
