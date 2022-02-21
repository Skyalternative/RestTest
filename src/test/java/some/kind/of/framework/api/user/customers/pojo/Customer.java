package some.kind.of.framework.api.user.customers.pojo;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private CustomerLinks _links;

    public Customer() {
    }

    public Customer(String id, String firstName, String lastName, String username, CustomerLinks _links) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this._links = _links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerLinks get_links() {
        return _links;
    }

    public void set_links(CustomerLinks _links) {
        this._links = _links;
    }
}


