package easy;

import org.junit.Before;
import org.junit.Test;

import main.Customer;
import main.CustomerCreator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;


public class TestCreateCustomer {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    
    @Before
    public void setUp() throws Exception {
        CustomerCreator customerCreator = new CustomerCreator("CustomerListPA5.csv");
        customerCreator.createCustomers();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = Customer.getCustomerMap().get(11);
        customer.printCustomer();

        String output = outputStream.toString().trim();

        String expected = "ID: 11" + System.lineSeparator() +
                          "First name: Aladdin" + System.lineSeparator() +
                          "Last name: Disney" + System.lineSeparator() +
                          "money available: 2221.83" + System.lineSeparator() +
                          "Money saved: 0.0" + System.lineSeparator() +
                          "Concert purchased: 0" + System.lineSeparator() +
                          "TicketMiner membership: true" + System.lineSeparator() +
                          "Username: aladdindisney" + System.lineSeparator() +
                          "Password: Fun!23";

        assertEquals(expected, output);
                          
    }
}
