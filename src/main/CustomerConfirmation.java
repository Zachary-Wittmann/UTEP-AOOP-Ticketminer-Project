package main;
/**
 * Description: This class is a singleton design pattern. This class is used to create a unique confirmation number.
 * @author Extreme Software Development Team
 */
public class CustomerConfirmation {


    //! Static is Global -> Can be accessed from outside the class.
    private static CustomerConfirmation  confirmation;

    /**
     *  Description: Default Constructor, Creating singleTon design pattern in a special way.
     */
    private CustomerConfirmation(){}


    /**
     * Description: This method gets the instance of CustomerConfirmation (singleton design pattern).
     * synchronized is so we do not access the same object at the same time.
     * @return The confirmation object.
     */
    public static synchronized CustomerConfirmation getInstance(){
        //! If object not created, create it.
        if(confirmation == null)
            confirmation = new CustomerConfirmation();
        //! Return the object.
        return confirmation;
    }

    /**
     * Description: This methods creates and returns a unique confirmation number.
     * @param customer Holds customer data.
     * @param nodeData Holds event data.
     * @param ticketOption holds the ticket type option.
     * @return The Confirmation number.
     */
    public int hashCode(Customer customer, NodeData nodeData, String ticketType){

        int hashCode = 0;
        try {
            hashCode = Math.abs(_EventTicketHashCode(nodeData, ticketType).hashCode() + _CustomerHashCode(customer).hashCode()) ;    
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return hashCode;
    }

    /**
     * Description: This method gets the string of customer data. This methods is a helper method to create a hashcode.
     * @param customer Holds customer data.
     * @return The string of customer data.
     */
    public String _CustomerHashCode(Customer customer){

        String hashCode = "";
        try {
            
            hashCode =  "" + String.valueOf(customer.getCustomerID() + customer.getCustomerTicketsPurchased() + customer.getTransactionCount()) + customer.getFirstName() + customer.getLastName() + customer.getCustomerUsername();
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return hashCode;
    }


    /**
     * Description: This method gets  the string of event data. This method is a helper method to create a hascode.
     * @param nodeData Holds event data.
     * @param ticketOption holds ticket type option.
     * @return The string of event data.
     */
    public String _EventTicketHashCode(NodeData nodeData, String ticketType){

        String hashCode = "";
        try {
            //! Get event and ticket data.
            Event eventData = nodeData.getEventData();
            TicketsHandler  ticketData = nodeData.getTicketsData();
    
            hashCode = "" + String.valueOf(eventData.getEventID()) + eventData.getEventName() + ticketType;     
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return hashCode;
    }

}
