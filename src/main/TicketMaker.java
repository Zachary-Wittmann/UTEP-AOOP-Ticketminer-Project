package main;

/**
 * Description: creating a ticket in this class
 * @author ESDT LLC
 * @since 11/09/2023
 */
public class TicketMaker {

    /**
     * Description: This method creates the ticket object of the purchase.
     * @param eventID Holds event ID.
     * @param customerID Holds customer ID.
     * @param subTotal Holds the sub total.
     * @param ticketCost Holds the total cost.
     * @param serviceFee Holds the service fee cost.
     * @param convenienceFee Holds the convenience fee cost.
     * @param charityFee Holds the charity fee cost.
     * @param ticketType Holds the ticket type.
     * @param ticketAmount Holds the amount tof ticket(s)
     * @param confirmationNNumber Holds the confirmation number.
     * @param totalSaved Holds the amount saved.
     * @return The ticket object.
     */
    public static Ticket createTicket(int eventID, int customerID,  double subTotal, double ticketCost, double serviceFee, double convenienceFee, double charityFee, String ticketType, int ticketAmount, String confirmationNNumber, double totalSaved ){
    
        //! Create the ticket object.
        Ticket ticket = new Ticket(ticketAmount, eventID, customerID, ticketType, ticketCost, subTotal, serviceFee, convenienceFee, charityFee,confirmationNNumber, totalSaved);
        //! Return the ticket object.
        return ticket;
    }
}