package easy;

import org.junit.Before;
import org.junit.Test;

import main.CancelTicket;
import main.ConfigureEventDetails;
import main.Customer;
import main.CustomerCreator;
import main.DoShopping;
import main.EventFactory;
import main.NodeData;
import main.Ticket;
import main.TicketsHandler;
import main.VenueFactory;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class TestCustomerCancelation {
    private CancelTicket cancelTicket;
    private DoShopping doShopping;
    private NodeData nodeData;
    private TicketsHandler ticketsHandler;
    private ConfigureEventDetails configureEventDetails;

    @Before
    public void setUp() {
        cancelTicket = new CancelTicket();
        doShopping = new DoShopping();
        nodeData = new NodeData();
        configureEventDetails = new ConfigureEventDetails("EventListPA5.csv", new EventFactory(), new VenueFactory());
        configureEventDetails.setFileDataToAttributes();
        CustomerCreator customerCreator = new CustomerCreator("CustomerListPA5.csv");
        customerCreator.createCustomers();
    }

    @Test
    public void testCancelTicket() {
        // get the node data
        nodeData = ConfigureEventDetails.getEventDataMap().get(1);
        ticketsHandler = nodeData.getTicketsData();
        Customer customer = Customer.getCustomerMap().get(96);
        
        // pass to shopping method in doShopping
        doShopping.shopping(nodeData, customer, 1, "VIP");
        doShopping.calculateFinances(customer, nodeData, ticketsHandler, "VIP", 1);

        
        // Prepare the input to simulate user entering "1" to cancel ticket
        String simulatedInput = "1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Prepare the input to simulate user entering "0" to exit the loop
        String terminateInput = "0\n";
        inputStream = new ByteArrayInputStream(terminateInput.getBytes());
        System.setIn(inputStream);
        
        // Call the method you want to test
        cancelTicket.cancelTicket(customer);

        // get customers purchased tickets
        ArrayList<Ticket> ticket = customer.getCustomerTransactions().get(1);
        // get specific tickets subtotal
        double subtotal = ticket.get(1).getSubTotal();

        assertEquals(63, subtotal, 0.001);
    }
}