package some.kind.of.framework.utils;

public enum Configuration {
    BASE_URL("test.config.base.url"),
    BASE_PORT("test.config.base.port"),
    USER_NAME("test.config.login.correct.username.1"),
    USER_PASSWORD("test.config.login.correct.password.1"),
    INVALID_USER_NAME("test.config.login.invalid.username.1"),
    INVALID_USER_PASSWORD("test.config.login.invalid.password.1");

    private final String val;

    Configuration(String envUrl) {
        this.val = envUrl;
    }

    public String getVal() {
        return val;
    }
}
