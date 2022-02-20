package some.kind.of.framework.api;

public class Api {
    private final ApiUsers apiUsers;

    public Api() {
        this.apiUsers = new ApiUsers();
    }

    public ApiUsers getApiUsers() {
        return apiUsers;
    }
}
