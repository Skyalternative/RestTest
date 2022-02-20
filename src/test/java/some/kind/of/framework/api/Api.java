package some.kind.of.framework.api;

import some.kind.of.framework.api.user.Users;

public class Api {
    private final Users users;

    public Api() {
        this.users = new Users();
    }

    public Users getUser() {
        return users;
    }
}
