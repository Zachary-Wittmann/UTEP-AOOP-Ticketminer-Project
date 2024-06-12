package main;
/**
 * Description: The class with the separate individual information from the inquiry to the admin. From Raul and Fernando
 * @author Raul Pallares
 * @author Fernando Remes
 * @since 10/12/2023
 */
public class AdminIndividualInquiry {
    /**
     * Description: Default Constructor
     */
    public AdminIndividualInquiry(){}
    
    /**
     * Description: Print seats remaining. From Fernando and Raul
     * @param ticketAvailabilityHandler Holds the ticket availability amount.
     */
    public void printTotalSR(TicketAnalytics ticketAvailabilityHandler){
        System.out.println("Total seats remaining: " + ticketAvailabilityHandler.getNumTicketsRemaining());
    }
    /**
     * Description: Print vip seats remaining. From Fernando and Raul
     * @param ticketAvailabilityHandler Holds the ticket availability amount.
     */
    public void printVipSR(TicketAnalytics ticketAvailabilityHandler){
        System.out.println("VIP seats remaining: " + ticketAvailabilityHandler.getNumVipTickets());
    }
    /**
     * Description: Print gold seats remaining. From Fernando and Raul.
     * @param ticketAvailabilityHandler Holds the ticket availability amount.
     */
    public void printGoldSR(TicketAnalytics ticketAvailabilityHandler){
        System.out.println("Gold seats remaining: " + ticketAvailabilityHandler.getNumGoldTickets());
    }
    /**
     * Description: Print silver seats remaining. From Fernando and Raul.
     * @param ticketAvailabilityHandler Holds the ticket availability amount.
     */
    public void printSilverSR(TicketAnalytics ticketAvailabilityHandler){
        System.out.println("Silver seats remaining: " + ticketAvailabilityHandler.getNumSilverTickets());
    }
    /**
     * Description: Print the bronze seats remaining. From Fernando and Raul.
     * @param ticketAvailabilityHandler Holds the ticket availability amount.
     */
    public void printBronzeSR(TicketAnalytics ticketAvailabilityHandler){
        System.out.println("Bronze seats remaining: " + ticketAvailabilityHandler.getNumBronzeTickets());
    }
    /**
     * Description: Print the general admission seats remaining. From Fernando and Raul.
     * @param ticketAvailabilityHandler Holds the ticket availability amount
     */
    public void printGeneralSR(TicketAnalytics ticketAvailabilityHandler){
        System.out.println("General Admission seats remaining: " + ticketAvailabilityHandler.getNumGeneralAdmissionTicket());
    }
    /**
     * Description: print total seats remaining except for the reserved seats. From Fernando and Raul.
     * @param ticketAvailabilityHandler Holds the ticket availability amount
     */
    public void printTotalSeatsExRsv(TicketAnalytics ticketAvailabilityHandler){
        System.out.println("Total seats remaining(Excluding reserved): " + ticketAvailabilityHandler.getNumTicketsRemaining());
    }
    /**
     * Description: print total amount of vip tickets. From Fernando and Raul.
     * @param profitAndRevenueHandler Holds the information of the profits and revenue. 
     */
    public void printVIPCollected(TicketAnalytics profitAndRevenueHandler){
        System.out.println("Total amount collected for VIP tickets: " + profitAndRevenueHandler.getTotalVipTicketsRevenue());
    }
    /**
     * Description: print total amount of gold tickets. From Fernando and Raul.
     * @param profitAndRevenueHandler Holds the information of the profits and revenue.
     */
    public void printGoldCollected(TicketAnalytics profitAndRevenueHandler){
        System.out.println("Total amount collected for Gold tickets: " + profitAndRevenueHandler.getTotalGoldTicketsRevenue());
    }
    /**
     * Description: print silver tickets collected. From Fernando and Raul.
     * @param profitAndRevenueHandler Holds the information of the profits and revenue.
     */
    public void printSilverCollected(TicketAnalytics profitAndRevenueHandler){
        System.out.println("Total amount collected for Silver tickets: " + profitAndRevenueHandler.getTotalSilverTicketsRevenue());
    }
    /**
     * Description: print bronze tickets collected. From Fernando and Raul.
     * @param profitAndRevenueHandler Holds the information of the profits and revenue.
     */
    public void printBronzeCollected(TicketAnalytics profitAndRevenueHandler){
        System.out.println("Total amount collected for Bronze tickets: " + profitAndRevenueHandler.getTotalBronzeTicketsRevenue());
    }
    /**
     * Description: print general admission tickets collected. From Fernando and Raul.
     * @param profitAndRevenueHandler Holds the information of the profits and revenue.
     */
    public void printGeneralCollected(TicketAnalytics profitAndRevenueHandler){
        System.out.println("Total amount collected for General Admission tickets: " + profitAndRevenueHandler.getTotalGeneralTicketsRevenue());
    }
    /**
     * Description: print total amount of tickets from all the seat sold. From Fernando and Raul.
     * @param profitAndRevenueHandler Holds the information of the profits and revenue.
     */
    public void printTotalCollected(TicketAnalytics profitAndRevenueHandler){
        System.out.println("Total amount collected from all seats: " + profitAndRevenueHandler.getTotalRevenueAllTickets());
    }
    /**
     * Description: print the expected profit. From Fernando and Raul.
     * @param profitAndRevenueHandler Holds the information of the profits and revenue.
     */
    public void printExpectedProfit(TicketAnalytics profitAndRevenueHandler){
        System.out.println("Total profit expected: " + profitAndRevenueHandler.getExpectedProfit());
    }
    /**
     * Description: print the current profit. From Fernando and Raul.
     * @param profitAndRevenueHandler Holds the information of the profits and revenue.
     */ 
    public void printCurrentProfit(TicketAnalytics profitAndRevenueHandler){
        System.out.println("Current Profit: " + profitAndRevenueHandler.getActualProfit());
    }
}
