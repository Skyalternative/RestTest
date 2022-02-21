package some.kind.of.framework.api.user.customers;

public class Customers {
    private final String customers;
    private final String customersCards;

    public Customers() {
        this.customers = "customers";
        this.customersCards = "cards";
    }

    public String getCustomers() {
        return customers;
    }

    public String getCustomer(String customerId) {
        return customers + "/" + customerId;
    }

    public String getCustomerCards(String customerId) {
        StringBuilder stringBuilder = new StringBuilder(this.customers);
        stringBuilder.append("/");
        stringBuilder.append(customerId);
        stringBuilder.append("/");
        stringBuilder.append(this.customersCards);
        return stringBuilder.toString();
    }
}

