package main;
import java.util.HashMap;
/**
 * @author Extreme Software Development Team LLC
 * @since October 27, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The TicketAnalytics.java file is used to create information on the events for the administrator to see.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann, some method were added by collaborating
 * without any help from outside sources apart from the instructor and his assistants.
 */
public class TicketAnalytics extends Event {

    //! Attributes to hold the number of different types of tickets available.Fernando and Raul.
    private int numVipTickets;
    private int numGoldTickets;
    private int numSilverTickets;
    private int numBronzeTickets;
    private int numGeneralAdmissionTicket;
    private int numReservedExtraTickets;
    private int numUnavailableTickets;
    private int numTicketsRemaining;

    //! Store tickets sold per event.
    private int totalSeatsSold;
    private int totalVipSeatsSold;
    private int totalGoldSeatsSold;
    private int totalSilverSeatsSold;
    private int totalBronzeSeatsSold;
    private int totalGeneralSeatsSold;

    //! Store revenue and profit.
    private double totalVipTicketsRevenue;
    private double totalGoldTicketsRevenue;
    private double totalSilverTicketsRevenue;
    private double totalBronzeTicketsRevenue;
    private double totalGeneralTicketsRevenue;
    private double totalRevenueAllTickets;
    private double expectedProfit;
    private double actualProfit;


    //! Store ticket numbers.
    private HashMap<String, Integer> ticketsAvailable = new HashMap<>();

    /**
     * Description: Creates an empty instance of TicketAnalytics
     * 
     */
    TicketAnalytics() {

    }

    
    /**
     * Description: Constructor, Initialize seats and profit.
     * @param reservedSeats Holds reserved seats.
     * @param unavailableSeats Holds unavailable seats.
     * @param vipSeats Holds vip seats
     * @param goldSeats Holds gold seats.
     * @param silverSeats Holds silver seats
     * @param bronzeSeats Holds bronze seats
     * @param generalSeats Holds general seats.
     * @param expectedProfit Holds expected profit
     * @param actualProfit Holds actual profit.
     */
    public TicketAnalytics(int totalNumTickets,int reservedSeats,int unavailableSeats, int vipSeats, int goldSeats, int silverSeats, int bronzeSeats,int generalSeats, double expectedProfit, double actualProfit) {
            setReservedExtraTickets(reservedSeats);
            setNumUnavailableTickets(unavailableSeats);
            setNumVipTickets(vipSeats);
            setNumGoldTickets(goldSeats);
            setNumBronzeTickets(bronzeSeats);
            setNumSilverTickets(silverSeats);
            setGeneralAdmissionTicket(generalSeats);
            setExpectedProfit(expectedProfit);
            setActualProfit(actualProfit);
            setNumTicketsRemaining(totalNumTickets);
    }   


    /**
     * Description: Gets the number of unavailable tickets.Fernando and Raul.
     * @return The number of unavailable tickets available
     */
    public int getNumUnavailableTickets() {
        return this.numUnavailableTickets;
    }
    /**
     * Description: Sets the number of unavailable tickets.Fernando and Raul.
     * @param numUnavailableTickets Represents the number of unavailable tickets
     */
    public void setNumUnavailableTickets(int numUnavailableTickets) {
        this.numUnavailableTickets = numUnavailableTickets;
    }

    /**
     * Description: Gets the number of vip tickets.Fernando and Raul.
     * @return The number of vip tickets available
     */
    public int getNumVipTickets() {
        return this.numVipTickets;
    }
    /**
     * Description: Sets the number of vip tickets.Fernando and Raul.
     * @param numVipTickets Represents the number of vip tickets available
     */
    public void setNumVipTickets(int numVipTickets) {
        this.numVipTickets = numVipTickets;
    }

    /**
     * Description: Gets the number of gold tickets.Fernando and Raul.
     * @return The number of Gold tickets available
     */
    public int getNumGoldTickets() {
        return this.numGoldTickets;
    }
    /**
     * Description: Set the number of gold tickets.Fernando and Raul.
     * @param numGoldTickets Represents the number of Gold tickets available
     */
    public void setNumGoldTickets(int numGoldTickets) {
        this.numGoldTickets = numGoldTickets;
    }

    /**
     * Description: Get the number of silver tickets.Fernando and Raul.
     * @return The number of Silver tickets available
     */
    public int getNumSilverTickets() {
        return this.numSilverTickets;
    }
    /**
     * Description: Set the number of silver tickets.Fernando and Raul.
     * @param numSilverTickets Represents the number of Silver tickets available
     */
    public void setNumSilverTickets(int numSilverTickets) {
        this.numSilverTickets = numSilverTickets;
    }

    /**
     * Description: Get the number of bronze tickets.Fernando and Raul.
     * @return The number of Bronze tickets available
     */
    public int getNumBronzeTickets() {
        return this.numBronzeTickets;
    }
    /**
     * Description: Set the number of bronze tickets.Fernando and Raul.
     * @param numBronzeTickets Represents the number of Bronze tickets available
     */
    public void setNumBronzeTickets(int numBronzeTickets) {
        this.numBronzeTickets = numBronzeTickets;
    }

    /**
     * Description: Get the number of general admission tickets.Fernando and Raul.
     * @return The number of General Admission tickets available
     */
    public int getNumGeneralAdmissionTicket() {
        return this.numGeneralAdmissionTicket;
    }
    /**
     * Description: Set the number of general admission tickets.Fernando and Raul.
     * @param numGeneralAdmissionTicket Represents the number of General Admission tickets available
     */
    public void setGeneralAdmissionTicket(int numGeneralAdmissionTicket) {
        this.numGeneralAdmissionTicket = numGeneralAdmissionTicket;
    }

    /**
     * Description: Get the number of reserved extra tickets.Fernando and Raul.
     * @return The number of Reserved Extra tickets.
     */
    public int getNumReservedExtraTickets() {
        return this.numReservedExtraTickets;
    }
    /**
     * Description: Set the number of reserved extra tickets.Fernando and Raul.
     * @param numReservedExtraTickets Represents the number of Reserved Extra tickets available.
     */
    public void setReservedExtraTickets(int numReservedExtraTickets) {
        this.numReservedExtraTickets = numReservedExtraTickets;
    }

    /**
     * Description: Get the total number of tickets remaining.Fernando and Raul.
     * @return the number of tickets remaining
     */
    public int getNumTicketsRemaining() {
        return this.numTicketsRemaining;
    }
    /**
     * Description: Set the number of tickets remaining.Fernando and Raul.
     * @param numTicketsRemaining Holds the remaining tickets.
     */
    public void setNumTicketsRemaining(int numTicketsRemaining) {
        this.numTicketsRemaining = numTicketsRemaining;
    }

    /**
     * Description: Get the total seats sold.
     * @return The total seats sold.
     */
    public int getTotalSeatsSold() {
        return this.totalSeatsSold;
    }

    /**
     * Description: Set the total seats sold.
     * @param totalSeatsSold HOlds total seats sold.
     */
    public void setTotalSeatsSold(int totalSeatsSold) {
        this.totalSeatsSold = totalSeatsSold;
    }

    /**
     * Description: Get the total vip seats sold.
     * @return The vip seats sold.
     */
    public int getTotalVipSeatsSold() {
        return this.totalVipSeatsSold;
    }

    /**
     * Description: Set the total vip seats sold.
     * @param totalVipSeatsSold Holds vips seats sold
     */
    public void setTotalVipSeatsSold(int totalVipSeatsSold) {
        this.totalVipSeatsSold = totalVipSeatsSold;
    }

    /**
     * Description: Get the total gold seats sold.
     * @return The gold seats sold.
     */
    public int getTotalGoldSeatsSold() {
        return this.totalGoldSeatsSold;
    }

    /**
     * Description: Set the total gold seats sold.
     * @param totalGoldSeatsSold holds gold seats sold.
     */
    public void setTotalGoldSeatsSold(int totalGoldSeatsSold) {
        this.totalGoldSeatsSold = totalGoldSeatsSold;
    }

    /**
     * Description: Get the total silver seats sold.
     * @return The silver seats sold.
     */
    public int getTotalSilverSeatsSold() {
        return this.totalSilverSeatsSold;
    }

    /**
     * Description: Set the total silver seats sold.
     * @param totalSilverSeatsSold Holds silver seats sold.
     */
    public void setTotalSilverSeatsSold(int totalSilverSeatsSold) {
        this.totalSilverSeatsSold = totalSilverSeatsSold;
    }

    /**
     * Description: Get the total bronze seats sold.
     * @return The bronze seats sold.
     */
    public int getTotalBronzeSeatsSold() {
        return this.totalBronzeSeatsSold;
    }

    /**
     * Description: Set the total bronze seats sold.
     * @param totalBronzeSeatsSold Holds bronze seats sold.
     */
    public void setTotalBronzeSeatsSold(int totalBronzeSeatsSold) {
        this.totalBronzeSeatsSold = totalBronzeSeatsSold;
    }

    /**
     * Description: Get the total general admission seats sold.
     * @return The general admission seats sold.
     */
    public int getTotalGeneralSeatsSold() {
        return this.totalGeneralSeatsSold;
    }

    /**
     * Description: Set the total general admission seats sold.
     * @param totalGeneralSeatsSold Holds the general admission seats sold.
     */
    public void setTotalGeneralSeatsSold(int totalGeneralSeatsSold) {
        this.totalGeneralSeatsSold = totalGeneralSeatsSold;
    }

    /**
     * Description: Get the total vip revenue.
     * @return The vip revenue.
     */
    public double getTotalVipTicketsRevenue() {
        return this.totalVipTicketsRevenue;
    }

    /**
     * Description: Set the total vip revenue.
     * @param totalVipTicketsRevenue Holds vip revenue.
     */
    public void setTotalVipTicketsRevenue(double totalVipTicketsRevenue) {
        this.totalVipTicketsRevenue = totalVipTicketsRevenue;
    }

    /**
     * Description: Get the total gold revenue.
     * @return The gold revenue.
     */
    public double getTotalGoldTicketsRevenue() {
        return this.totalGoldTicketsRevenue;
    }

    /**
     * Description: Set the total gold revenue.
     * @param totalGoldTicketsRevenue Holds gold revenue.
     */
    public void setTotalGoldTicketsRevenue(double totalGoldTicketsRevenue) {
        this.totalGoldTicketsRevenue = totalGoldTicketsRevenue;
    }

    /**
     * Description: Get the total silver revenue.
     * @return The silver revenue.
     */
    public double getTotalSilverTicketsRevenue() {
        return this.totalSilverTicketsRevenue;
    }

    /**
     * Description: Set the total silver revenue.
     * @param totalSilverTicketsRevenue Holds silver revenue.
     */
    public void setTotalSilverTicketsRevenue(double totalSilverTicketsRevenue) {
        this.totalSilverTicketsRevenue = totalSilverTicketsRevenue;
    }

    /**
     * Description: Get the total bronze revenue.
     * @return the bronze revenue.
     */
    public double getTotalBronzeTicketsRevenue() {
        return this.totalBronzeTicketsRevenue;
    }

    /**
     * Description: Set the total bronze revenue.
     * @param totalBronzeTicketsRevenue holds bronze revenue.
     */
    public void setTotalBronzeTicketsRevenue(double totalBronzeTicketsRevenue) {
        this.totalBronzeTicketsRevenue = totalBronzeTicketsRevenue;
    }

    /**
     * Description: Get the total general admission revenue.
     * @return The general admission revenue.
     */
    public double getTotalGeneralTicketsRevenue() {
        return this.totalGeneralTicketsRevenue;
    }

    /**
     * Description: Set the total general admission revenue.
     * @param totalGeneralTicketsRevenue HOlds general admission revenue.
     */
    public void setTotalGeneralTicketsRevenue(double totalGeneralTicketsRevenue) {
        this.totalGeneralTicketsRevenue = totalGeneralTicketsRevenue;
    }

    /**
     * Description: Get the total revenue for all tickets.
     * @return The all revenue.
     */
    public double getTotalRevenueAllTickets() {
        return this.totalRevenueAllTickets;
    }

    /**
     * Description: Set the total revenue for all tickets.
     * @param totalRevenueAllTickets Holds all revenue.
     */
    public void setTotalRevenueAllTickets(double totalRevenueAllTickets) {
        this.totalRevenueAllTickets = totalRevenueAllTickets;
    }

    /**
     * Description: Get the expected profit.
     * @return The expected profit.
     */
    public double getExpectedProfit() {
        return this.expectedProfit;
    }

    /**
     * Description: Set the expected profit.
     * @param expectedProfit HOlds expected profit.
     */
    public void setExpectedProfit(double expectedProfit) {
        this.expectedProfit = expectedProfit;
    }

    /**
     * Description: Get the actual profit.
     * @return The actual profit. 
     */
    public double getActualProfit() {
        return this.actualProfit;
    }

    /**
     *Description: Set the actual profit.
     * @param actualProfit Holds actual profit.
     */
    public void setActualProfit(double actualProfit) {
        this.actualProfit = actualProfit;
    }

    /**
     * Description: Get the tickets available.
     * @return The tickets available hashMap.
     */
    public HashMap<String, Integer> getTicketsAvailable() {
        return this.ticketsAvailable;
    }
    /**
     * Description: Set the tickets available.
     * @param ticketsavailable Holds tickets available data.
     */
    public void setTicketsAvailable(HashMap<String, Integer> ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }


    /**
     * Description: This method updates profits,revenue, tickets after every purchase.
     * @param numTickets Holds amount of tickets.
     * @param totalCost holds ticket cost.
     * @param ticketType holds ticket type.
     */
    public void updateAnalytics(int numTickets, double totalCost, String ticketType){
        
        //! Update number of sold tickets
        setTotalSeatsSold(getTotalSeatsSold() + numTickets );

        //! Update number of tickets remaining for event.
        setNumTicketsRemaining(getNumTicketsRemaining() - numTickets);
        //! Update all revenue.
        setTotalRevenueAllTickets(getTotalRevenueAllTickets() + totalCost);
        //! Update actual profit.
        setActualProfit(getActualProfit() + totalCost);


        //! update profit, tickets sold, availability for ticket type.
        switch (ticketType.toLowerCase()) {
            case "vip":
                setNumVipTickets(getNumVipTickets() - numTickets);
                setTotalVipSeatsSold(getTotalVipSeatsSold() + numTickets);
                setTotalVipTicketsRevenue(getTotalVipTicketsRevenue() + totalCost);
                break;
            case "gold":
                setNumGoldTickets(getNumGoldTickets() - numTickets);
                setTotalGoldSeatsSold(getTotalGoldSeatsSold() + numTickets);
                setTotalGoldTicketsRevenue(getTotalGoldTicketsRevenue() + totalCost);
                break;
            case "silver":
                setNumSilverTickets(getNumSilverTickets() - numTickets);
                setTotalSilverSeatsSold(getTotalSilverSeatsSold() + numTickets);
                setTotalSilverTicketsRevenue(getTotalSilverTicketsRevenue() + totalCost);
                break;
            case "bronze":
                setNumBronzeTickets(getNumBronzeTickets() - numTickets);
                setTotalBronzeSeatsSold(getTotalSilverSeatsSold() + numTickets);
                setTotalBronzeTicketsRevenue(getTotalBronzeTicketsRevenue() + totalCost);
                break;
            case "general admission":
                setGeneralAdmissionTicket(getNumGeneralAdmissionTicket() - numTickets);
                setTotalGeneralSeatsSold(getTotalGeneralSeatsSold() + numTickets);
                setTotalGeneralTicketsRevenue(getTotalGeneralTicketsRevenue() + totalCost);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
        //! Update hashMap ticket availability.
        updateTicketHashmap();
    }


    /**
     * Description: This method stores number of tickets in a hashMap to access quickly.
     */
    public void updateTicketHashmap(){

        try {
            getTicketsAvailable().put("vip", getNumVipTickets());
            getTicketsAvailable().put("gold", getNumGoldTickets());
            getTicketsAvailable().put("silver", getNumSilverTickets());
            getTicketsAvailable().put("bronze", getNumBronzeTickets());
            getTicketsAvailable().put("general admission", getNumGeneralAdmissionTicket());      
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: This method checks ticket availability for an event.
     * @param ticketType Holds ticket type.
     * @param numTickets holds amount of tickets.
     * @return The boolean true if enough ticket(s) else false.
     */
    public boolean ticketAvailability(String ticketType, int numTickets){
        //! Update hashMap that has ticket numbers.
        updateTicketHashmap();
        //! Return true if enough tickets else false.
        return (getTicketsAvailable().get(ticketType.toLowerCase()) >= numTickets);
    }

    /**
     * Description: This method updates profits,revenue, tickets after every purchase.
     * @param numTickets Holds amount of tickets.
     * @param totalCost holds ticket cost.
     * @param ticketType holds ticket type.
     */
    public void updateReimbursementsAnalytics(int numTickets, double totalCost, String ticketType){
        
        //! Update number of sold tickets
        setTotalSeatsSold(getTotalSeatsSold() - numTickets );

        //! Update number of tickets remaining for event.
        setNumTicketsRemaining(getNumTicketsRemaining() + numTickets);
        //! Update all revenue.
        setTotalRevenueAllTickets(getTotalRevenueAllTickets() - totalCost);
        //! Update actual profit.
        setActualProfit(getActualProfit() - totalCost);


        //! update profit, tickets sold, availability for ticket type.
        switch (ticketType.toLowerCase()) {
            case "vip":
                setNumVipTickets(getNumVipTickets() + numTickets);
                setTotalVipSeatsSold(getTotalVipSeatsSold() - numTickets);
                setTotalVipTicketsRevenue(getTotalVipTicketsRevenue() - totalCost);
                break;
            case "gold":
                setNumGoldTickets(getNumGoldTickets() + numTickets);
                setTotalGoldSeatsSold(getTotalGoldSeatsSold() - numTickets);
                setTotalGoldTicketsRevenue(getTotalGoldTicketsRevenue() - totalCost);
                break;
            case "silver":
                setNumSilverTickets(getNumSilverTickets() + numTickets);
                setTotalSilverSeatsSold(getTotalSilverSeatsSold() - numTickets);
                setTotalSilverTicketsRevenue(getTotalSilverTicketsRevenue() - totalCost);
                break;
            case "bronze":
                setNumBronzeTickets(getNumBronzeTickets() + numTickets);
                setTotalBronzeSeatsSold(getTotalSilverSeatsSold() - numTickets);
                setTotalBronzeTicketsRevenue(getTotalBronzeTicketsRevenue() - totalCost);
                break;
            case "general admission":
                setGeneralAdmissionTicket(getNumGeneralAdmissionTicket() + numTickets);
                setTotalGeneralSeatsSold(getTotalGeneralSeatsSold() - numTickets);
                setTotalGeneralTicketsRevenue(getTotalGeneralTicketsRevenue() - totalCost);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
        //! Update hashMap ticket availability.
        updateTicketHashmap();
    }
}