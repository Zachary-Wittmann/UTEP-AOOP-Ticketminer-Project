package hard;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import main.DoShopping;
import main.EventFactory;
import main.NodeData;
import main.VenueFactory;
import main.ConfigureEventDetails;
import main.Customer;
import main.CustomerCreator;


public class TestDoShoppingScenarios {

    private ConfigureEventDetails configureEventDetails;
    private DoShopping doShopping;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;
    
    @Before
    public void setUp() {
        doShopping = new DoShopping();
        configureEventDetails = new ConfigureEventDetails("EventListPA5.csv", new EventFactory(), new VenueFactory());
        configureEventDetails.setFileDataToAttributes();
        CustomerCreator customerCreator = new CustomerCreator("CustomerListPA5.csv");
        customerCreator.createCustomers();
        System.setOut(new PrintStream(output));
    }


    @Test
    public void TestCustomerNotEnoughMoney() {


        try {
            // get the node data
            NodeData nodeData = ConfigureEventDetails.getEventDataMap().get(1);
    
            Customer customer = Customer.getCustomerMap().get(70);
    
            customer.setCustomerMoneyAvailable(0.0);
    
            // pass to shopping method in doShopping
            doShopping.shopping(nodeData, customer, 5, nodeData.getTicketsData().getTicketNames().get(1));
    
            String expectedInfo = "Sorry, You do not have enough money available" + System.lineSeparator();

            assertEquals(expectedInfo, output.toString());
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void TestCustomerNotEnoughTickets() {


        try {
            // get the node data
            NodeData nodeData = ConfigureEventDetails.getEventDataMap().get(1);

            nodeData.getTicketsData().getTicketAnalytics().setNumVipTickets(0);
    
            Customer customer = Customer.getCustomerMap().get(70);

    
            // pass to shopping method in doShopping
            doShopping.shopping(nodeData, customer, 5, nodeData.getTicketsData().getTicketNames().get(1));
    
            String expectedInfo = "Sorry, not enough tickets available" + System.lineSeparator();

            assertEquals(expectedInfo, output.toString());
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }






}
