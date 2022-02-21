package some.kind.of.framework.api.user;

import some.kind.of.framework.api.user.customers.Customers;

public class Users {
    private final String login;
    private final String register;
    private final Customers customers;

    public Users() {
        this.login = "login";
        this.register = "register";
        this.customers = new Customers();
    }

    public String getLogin() {
        return login;
    }

    public String getRegister() {
        return register;
    }

    public Customers getCustomers() {
        return customers;
    }
}
