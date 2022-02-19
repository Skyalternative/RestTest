package some.kind.of.framework.utils;

public enum Configuration {
    BASE_URL("test.config.base.url"),
    USER_NAME("test.config.login.username.1"),
    USER_PASSWORD("test.config.login.password.1");

    private String val;

    Configuration(String envUrl) {
        this.val = envUrl;
    }

    public String getVal() {
        return val;
    }
}
