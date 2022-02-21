package some.kind.of.framework.data;

public enum CookiesWeaveSocks {
    LOGGED_IN("logged_in");

    private final String val;

    CookiesWeaveSocks(String envUrl) {
        this.val = envUrl;
    }

    public String getVal() {
        return val;
    }
}
