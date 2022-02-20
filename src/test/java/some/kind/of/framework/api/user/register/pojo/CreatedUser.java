package some.kind.of.framework.api.user.register.pojo;

public class CreatedUser {
    private String id;

    public CreatedUser() {
    }

    public CreatedUser(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
