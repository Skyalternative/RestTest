package some.kind.of.framework.utils;

import some.kind.of.framework.api.Api;
import some.kind.of.framework.api.ApiHandler;
import some.kind.of.framework.data.LoginState;

public class TestFactory {
    public ApiHandler getApi(LoginState loginState) {
        ApiHandler apiHandler = new ApiHandler(new ConfigHandler(), new Api());

        if (loginState == LoginState.LOGGED_IN) {
            apiHandler.setLoginState(LoginState.LOGGED_IN);
        }

        return apiHandler;
    }
}
