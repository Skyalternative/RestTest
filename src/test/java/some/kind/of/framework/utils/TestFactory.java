package some.kind.of.framework.utils;

import some.kind.of.framework.api.Api;
import some.kind.of.framework.api.ApiHandler;

public class TestFactory {
    public ApiHandler getApi(Login loginState) {
        ApiHandler api = new ApiHandler(new ConfigHandler(), new Api());

        if (loginState == Login.LOGGED_IN) {
             api.login().then().statusCode(200);
        }

        return api;
    }
}
