package main;
/**
 * Description: creates a object of Ticket type
 * @author Extreme Software Development Team
 * @since 11/02/2023
 */

public class Ticket {

    //! Attributes.
    private int ticketNum;
    private int eventID;
    private int CustomerID;
    private String ticketType;
    private double ticketCost;
    private double subTotal;
    private double serviceFee;
    private double convenienceFee;
    private double charityFee;
    private double totalSaved;
    private String confirmationNumber;


    /**
     * Description: Default Constructor.
     */
    public Ticket(){}
    
    /**
     * Description: constructor for Ticket class
     * @param ticketNum Holds amount of tickets.
     * @param eventID Holds event ID.
     * @param eventName Holds event name.
     * @param ticketType Holds ticket type.
     * @param ticketCost Holds ticket cost.
     */
    public Ticket(int ticketNum, int eventID,int customerID, String ticketType, double ticketCost, double subTotal, double serviceFee, double convenienceFee, double charityFee, String confirmationNumber, double totalSaved) {
        this.ticketNum = ticketNum;
        this.eventID = eventID;
        this.CustomerID = customerID;
        this.ticketType = ticketType;
        this.ticketCost = ticketCost;
        this.subTotal = subTotal;
        this.serviceFee = serviceFee;
        this.convenienceFee = convenienceFee;
        this.charityFee = charityFee;
        this.confirmationNumber = confirmationNumber;
        this.totalSaved = totalSaved;
        
    }

    // Getters and Setters
    /**
     * Description: Get the ticket number.
     * @return The ticket's number
     */
    public int getTicketNum() {
        return this.ticketNum;
    }

    /**
     * Description: Set the ticket number.
     * @param ticketNum HOlds ticket number.
     */
    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    /**
     * Description: Get the event ID number.
     * @return The event on the ticket's ID
     */
    public int getEventID() {
        return this.eventID;
    }

    /**
     * Description: Set the event ID number.
     * @param eventID HOlds event ID number
     */
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     * Description: Get customer ID.
     * @return The customer ID.
     */
    public int getCustomerID() {
        return this.CustomerID;
    }
    /**
     * Description: Set the customer ID.
     * @param customerID Holds the customer ID.
     */
    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    /**
     * Description: Get the ticket type.
     * @return The ticket's type for seating
     */
    public String getTicketType() {
        return this.ticketType;
    }

    /**
     * Description: Set the ticket type.
     * @param ticketType Holds ticket type.
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * Description: Get the ticket cost.
     * @return The cost of the ticket
     */
    public double getTicketCost() {
        return this.ticketCost;
    }

    /**
     * Description: Set the ticket cost.
     * @param ticketCost Holds ticket cost.
     */
    public void setTicketCost(double ticketCost){
        this.ticketCost = ticketCost;
    }
    /**
     * Description: Get the subtotal.
     * @return The subtotal
     */
    public double getSubTotal() {
        return this.subTotal;
    }
    /**
     * Description: Set the subtotal.
     * @param subTotal Holds subtotal amount.
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Description: Get the service fee.
     * @return The service fee.
     */
    public double getServiceFee() {
        return this.serviceFee;
    }
    /**
     * Description: Set the service fee.
     * @param serviceFee Holds service fee amount.
     */
    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    /**
     * Description: Get the convenience fee.
     * @return The convenience fee.
     */
    public double getConvenienceFee() {
        return this.convenienceFee;
    }
    /**
     * Description: Set the convenience fee.
     * @param convenienceFee Holds convenience fee amount.
     */
    public void setConvenienceFee(double convenienceFee) {
        this.convenienceFee = convenienceFee;
    }

    /**
     * Description: Get the charity fee.
     * @return The charity fee
     */
    public double getCharityFee() {
        return this.charityFee;
    }
    /**
     * Description: Set the charity fee.
     * @param charityFee Holds charity fee amount.
     */
    public void setCharityFee(double charityFee) {
        this.charityFee = charityFee;
    }
    /**
     * Description: Get the confirmation number.
     * @return The confirmation number
     */
    public String getConfirmationNumber() {
        return this.confirmationNumber;
    }
    /**
     * Description: Set the confirmation number.
     * @param confirmationNumber Holds confirmation number.
     */
    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    /**
     * Description: Get the total saved.
     * @return The total saved.
     */
    public double getTotalSaved() {
        return this.totalSaved;
    }
    /**
     * Description: Set the total saved.
     * @param totalSaved Holds total saved amount.
     */
    public void setTotalSaved(double totalSaved) {
        this.totalSaved = totalSaved;
    }



}
