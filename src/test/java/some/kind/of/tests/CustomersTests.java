package some.kind.of.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import some.kind.of.framework.api.ApiHandler;
import some.kind.of.framework.api.user.customers.pojo.Customer;
import some.kind.of.framework.api.user.register.pojo.CreatedUser;
import some.kind.of.framework.api.user.register.pojo.NewUser;
import some.kind.of.framework.data.LoginState;
import some.kind.of.framework.utils.Helper;
import some.kind.of.framework.utils.TestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("Customers")
class CustomersTests {

    private ApiHandler api;

    @BeforeEach
    public void setUp() {
        api = new TestFactory().getApi(LoginState.LOGGED_IN);
    }

    @Test
    @DisplayName("Get all customers")
    @Tag("Positive")
    void getCustomersTest() {
        Response response = api.getAllCustomers();

        response.then().statusCode(HttpStatus.SC_OK);
        assertNotNull(response.body());
    }

    @Test
    @DisplayName("Create new customer")
    @Tag("Positive")
    void putCustomerTest() throws JsonProcessingException {
        NewUser customerToCreate = new NewUser(Helper.getRandomString(10), Helper.getRandomString(10), Helper.getRandomEmail(10));
        Response response = api.registerNewUser(customerToCreate);

        response.then().statusCode(HttpStatus.SC_OK);

        // Api return body with unsupported content-type
        CreatedUser customerCreated = new ObjectMapper().readValue(
                response.then().extract().body().asPrettyString(),
                CreatedUser.class
        );
        Customer readCreatedCustomer = new ObjectMapper().readValue(
                api.getCustomer(customerCreated.getId()).then().extract().body().asPrettyString(),
                Customer.class
        );

        assertEquals(customerToCreate.getUsername(), readCreatedCustomer.getUsername(), "Created customer have invalid username");
    }
}
