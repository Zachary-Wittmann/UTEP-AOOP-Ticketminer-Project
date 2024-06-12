package easy;

import org.junit.Before;
import org.junit.Test;

import main.ConfigureEventDetails;
import main.Customer;
import main.CustomerCreator;
import main.DoShopping;
import main.EventFactory;
import main.NodeData;
import main.TicketsHandler;
import main.VenueFactory;

import static org.junit.Assert.*;

public class TestCustomerPurchase {
    private DoShopping doShopping;
    private NodeData nodeData;
    private TicketsHandler ticketsHandler;
    private ConfigureEventDetails configureEventDetails;

    @Before
    public void setUp() {
        doShopping = new DoShopping();
        nodeData = new NodeData();
        configureEventDetails = new ConfigureEventDetails("EventListPA5.csv", new EventFactory(), new VenueFactory());
        configureEventDetails.setFileDataToAttributes();
        CustomerCreator customerCreator = new CustomerCreator("CustomerListPA5.csv");
        customerCreator.createCustomers();
    }

    @Test 
    public void testPurchaseTicket() {
        // get the node data
        nodeData = ConfigureEventDetails.getEventDataMap().get(1);
        ticketsHandler = nodeData.getTicketsData();
        // pass to shopping method in doShopping
        doShopping.shopping(nodeData, Customer.getCustomerMap().get(96), 1, nodeData.getTicketsData().getTicketNames().get(1));
        // Assert the expected outcome
        Customer isMe = Customer.getCustomerMap().get(96);
        
        double total = doShopping.calculateFinances(isMe, nodeData, ticketsHandler, "VIP", 1);
        assertEquals(73.09, total, 0.001);
    }

    @Test 
    public void testPurchaseTicket2() {
        // get the node data
        nodeData = ConfigureEventDetails.getEventDataMap().get(1);
        ticketsHandler = nodeData.getTicketsData();
        Customer isMe = Customer.getCustomerMap().get(79);
        // pass to shopping method in doShopping
        doShopping.shopping(nodeData, isMe, 1, nodeData.getTicketsData().getTicketNames().get(1));
        // Assert the expected outcome
        
        
        double total = doShopping.calculateFinances(isMe, nodeData, ticketsHandler, "VIP", 1);
        assertEquals(66.27, total, 0.001);
    }
}