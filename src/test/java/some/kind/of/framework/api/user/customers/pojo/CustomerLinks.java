package some.kind.of.framework.api.user.customers.pojo;

public class CustomerLinks {
    private Href self;
    private Href customer;
    private Href addresses;
    private Href cards;

    public CustomerLinks() {
    }

    public CustomerLinks(Href self, Href customer, Href addresses, Href cards) {
        this.self = self;
        this.customer = customer;
        this.addresses = addresses;
        this.cards = cards;
    }

    public Href getSelf() {
        return self;
    }

    public void setSelf(Href self) {
        this.self = self;
    }

    public Href getCustomer() {
        return customer;
    }

    public void setCustomer(Href customer) {
        this.customer = customer;
    }

    public Href getAddresses() {
        return addresses;
    }

    public void setAddresses(Href addresses) {
        this.addresses = addresses;
    }

    public Href getCards() {
        return cards;
    }

    public void setCards(Href cards) {
        this.cards = cards;
    }
}
