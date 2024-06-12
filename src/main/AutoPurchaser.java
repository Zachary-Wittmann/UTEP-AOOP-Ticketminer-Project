package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Walter Wawra
 * @author Raul Pallares
 * @author Zach Wittmann
 * @author Fernando Remes
 * 
 * Description: This class calls the autopurchaser csv, reads it, and store it's information. Everything in the class and method were refactored and collaborated together via live share.
 * The data store will be dynamically stored and proceed to do shopping.
 */
public class AutoPurchaser {

    //! Attributes to store auto purchaser data.
    private String lastName;
    private String firstName;
    private String action;
    private int eventID;
    private String eventName;
    private int ticketQuantity;
    private String ticketType;

    /**
     * Description: Default, Constructor.
     */
    public AutoPurchaser(){}

    /**
     * Description: Get the customer first name.
     * @return The customer last name.
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * Description: Set the customer last name.
     * @param lastName Holds the customer last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Description: Get the customer first name.
     * @return The customer first name.
     */
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * Description: Set the customer first name.
     * @param firstName Holds the customer first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Description: Get the action
     * @return The action
     */
    public String getAction() {
        return this.action;
    }
    /**
     * Description:  Set the action.
     * @param action Holds the action (buy).
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Description: Get the event ID.
     * @return The event ID.
     */
    public int getEventID() {
        return this.eventID;
    }
    /**
     * Description: Set the event ID.
     * @param eventID Holds the event ID.
     */
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     * Description: Get the event name.
     * @return The event name.
     */
    public String getEventName() {
        return this.eventName;
    }
    /**
     * Description: Set teh event name.
     * @param eventName Holds the event name.
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Description: Get the amount of tickets.
     * @return The amount of tickets.
     */
    public int getTicketQuantity() {
        return this.ticketQuantity;
    }
    /**
     * Description: Set the amount of tickets.
     * @param ticketQuantity Holds the amount of tickets.
     */
    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }

    /**
     * Description: Get the ticket type.
     * @return The ticket type.
     */
    public String getTicketType() {
        return this.ticketType;
    }
    /**
     * Description: Set the ticket type.
     * @param ticketType Holds the ticket type.
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * Description: This method dynamically stores the excel data to attributes.
     * @param dataList Holds line of row text data to store.
     * @param headersList Holds the header columns of excel data.
     */
    public void storeAttributes(String [] dataList, String [] headersList){
        //! Get reference.
        ConversionOfDataTypes conversion = ConversionOfDataTypes.getInstance();
        
        try {
            //! Store the data.
            for (int i = 0; i < headersList.length; i++) {
                switch (headersList[i].toLowerCase()) {
                    case "first":
                        setFirstName(conversion.convertToString(dataList[i]));
                        break;
                    case "last":
                        setLastName(conversion.convertToString(dataList[i]));
                        break;
                    case "action":
                        setAction(conversion.convertToString(dataList[i]));
                        break;
                    case "event id":
                        setEventID(conversion.convertToInteger(dataList[i]));
                        break;
                    case "event name":
                        setEventName(conversion.convertToString(dataList[i]));
                        break;
                    case "ticket quantity":
                        setTicketQuantity(conversion.convertToInteger(dataList[i]));
                        break;
                    case "ticket type":
                        setTicketType(conversion.convertToString(dataList[i]));
                        break;
                    default:
                        System.out.println("Invalid type.");
                        break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Keys empty.");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array empty.");
        }
    }

    /**
     * Description: reads the csv file and stores the information.
     * @param filename points to the csv file.
     * @return The array list of data.
     */
    public ArrayList<String[]> readAutoPurchaserCSV(String filename) {
        //! Create instance.
        CSVReader reader = CSVReader.getInstance();
        //! Read and return the array list of data.
        return reader.readCSV(filename);
    }

    /**
     * Description: This method Does the auto purchase for the customer auto purchase excel file 100, 500k, 1M.
     * @param dataList Holds auto excel data.
     */
    public void doAutoShopping(ArrayList<String[]> dataList) {
        try {
            //!  Create do shopping object.
            DoShopping justDoIt = new DoShopping();

            //! Skip headers and do rest of purchases.
            for (int i = 1; i < dataList.size(); i++) {
                //! Get first row text.
                String []data = dataList.get(i);
                //! Store the data dynamically.
                storeAttributes(data, dataList.get(0));
                //! Get the event data.
                NodeData nodeData = findEventID(getEventID());
                //! Get the customer data.
                Customer customer = findCustomer(getFirstName().toLowerCase(), getLastName().toLowerCase());

                //! Check if action is buy, and event node and customer is not null. If so to shopping.
                if(getAction().equalsIgnoreCase("buy") && nodeData != null && customer != null){
                    customer.getCustomerLogger().configureCustomerDirectory();
                    customer.getCustomerLogger().configureCustomerLogger();    
                    justDoIt.shopping(nodeData, customer, getTicketQuantity(), getTicketType());
                    customer.getCustomerLogger().closeLogger();
                }

            }
        }catch(NullPointerException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }


    /**
     * Description: This method finds and returns the event target data.
     * @param target Holds the event ID to find.
     * @return The event data.
     */
    public NodeData findEventID(int target){

        //! Initialize the node to be null.
        NodeData node = null;
        try {
            //! Return the event data.
            node = ConfigureEventDetails.getEventDataMap().get(target);
            
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        //! Return the event node data.
        return node;
    }

    /**
     * Description: This method finds and returns the customer data from target first and last name.
     * @param firstName Holds the target first name to find.
     * @param lastName Holds the target last name to find.
     * @return The customer data.
     */
    public Customer findCustomer( String firstName, String lastName){

        //! Initialized customer to null.
        Customer customer = null;
        try {
            //! Get the ID for the full name.
            int key = Customer.getCustomerName().get(firstName + " "+ lastName);
            //! Get the customer data from the key.
            customer = Customer.getCustomerMap().get(key);
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        //! Return the customer.
        return customer;
    }

}
