package main;
/**
 * Description: This is the main ticket class. It has helper classes like ProfitAndRevenue, TicketAvailabilityHandler, and TicketSoldHandler classes to run tickets.
 * The attributes and getters/ setters did the same thing between Fernando's and Raul's code, just hand different attribute names.
 * @author Extreme Software Development Team LLC
 * @since 10/12/2023
 */

import java.util.ArrayList;


public class TicketsHandler {
    
    //! Tickets prices for the event.
    private double vipPrice;
    private double goldPrice;
    private double silverPrice;
    private double bronzePrice;
    private double generalAdmissionPrice;

    //! Used to store the prices of tickets in order. From Raul
    private ArrayList<Double> ticketPrices = new ArrayList<>();

    //! Used to store the names of the ticket types. From raul
    private ArrayList<String> ticketNames = new ArrayList<>();

    //! Object of TicketsAnalytics. From walter.
    private TicketAnalytics ticketsAnalytics;

    /**
     * Description: Default constructor.
     */
    public TicketsHandler(){}


    /**
     * Description: Set the tickets by the information in the ticket analytics. 
     * @param ticketAnalytics Holds the ticket 
     */
    public void setTicketsAnalytics(TicketAnalytics ticketAnalytics){
        this.ticketsAnalytics = ticketAnalytics;
    }

    /**
     * Description: Get the ticket analytics information.
     * @return the ticketAnalytics
     */
    public TicketAnalytics getTicketAnalytics(){
        return this.ticketsAnalytics;
    }
    /**
     * Description: Get the price for the vip ticket.Raul and fernando.
     * @return The vip price
     */
    public double getVipPrice() {
        return this.vipPrice;
    }
    /**
     * Description: Set the price for the vip ticket.Raul and fernando.
     * @param vipPrice Set vip price
     */
    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    /**
     * Description: Get the price for the gold ticket.Raul and fernando.
     * @return The gold price
     */
    public double getGoldPrice() {
        return this.goldPrice;
    }
    /**
     * Description: Set the price for the gold ticket.Raul and fernando.
     * @param goldPrice Set the Gold price
     */
    public void setGoldPrice(double goldPrice) {
        this.goldPrice = goldPrice;
    }

    /**
     * Description: Get the price for the silver ticket.Raul and fernando.
     * @return The Silver price
     */
    public double getSilverPrice() {
        return this.silverPrice;
    }
    /**
     * Description: Set the price for the silver ticket.Raul and fernando.
     * @param silverPrice Set the Silver price 
     */
    public void setSilverPrice(double silverPrice) {
        this.silverPrice = silverPrice;
    }

    /**
     * Description: Get the price for the bronze ticket.Raul and fernando.
     * @return The bronze price
     */
    public double getBronzePrice() {
        return this.bronzePrice;
    }
    /**
     * Description: Set the price for the bronze ticket.Raul and fernando.
     * @param bronzePrice Set the bronze price
     */
    public void setBronzePrice(double bronzePrice) {
        this.bronzePrice = bronzePrice;
    }

    /**
     * Description: Get the price for the general admission ticket.Raul and fernando.
     * @return The GeneralAdmission price
     */
    public double getGeneralAdmissionPrice() {
        return this.generalAdmissionPrice;
    }
    /**
     * Description: Set the price for the general admission ticket.Raul and fernando.
     * @param generalAdmissionPrice Set the general Admission price
     */
    public void setGeneralAdmissionPrice(double generalAdmissionPrice) {
        this.generalAdmissionPrice = generalAdmissionPrice;
    }

    /**
     * Description: Get the array list of names of tickets. From Raul.
     * @return The array list of ticket names.
     */
    public ArrayList<String> getTicketNames(){
        return this.ticketNames;
    }
    /**
     * Description: Adds the name sof the tickets to the array list.From Raul
     * @param index Holds position of ticket name to be added.
     * @param ticketName Holds the name of the ticket.
     */
    public void addTicketNames(int index,String ticketName) {
        getTicketNames().add(index, ticketName);
    }
    /**
     * Description: Store the tickets names in the array list.From Raul.
     */
    public void setTicketNames(){
        //! Set the tickets name and return the array.
        addTicketNames(0, "");
        addTicketNames(1, "Vip");
        addTicketNames(2, "Gold");
        addTicketNames(3, "Silver");
        addTicketNames(4, "Bronze");
        addTicketNames(5, "General Admission");   
    }

    /**
     * Description: Get the array list of ticket prices. From Raul.
     * @return The array list of ticket prices
     */
    public ArrayList<Double> getTicketPrices(){
        return this.ticketPrices;
    }

    /**
     * Description: Add to the array list the ticket price with respected index position.From Raul.
     * @param index Holds the index position to add to.
     * @param ticketPrice Holds the price of ticket
     */
    public void addTicketPrices(int index,double ticketPrice) {
        getTicketPrices().add(index, ticketPrice);
    }
    /**
     * Description: Store the ticket prices in the array list. From Raul.
     */
    public void setTicketPrices(){
        //! Set the ticket prices and return the array.
        addTicketPrices(0, 0.0);
        addTicketPrices(1, getVipPrice());
        addTicketPrices(2, getGoldPrice());
        addTicketPrices(3, getSilverPrice());
        addTicketPrices(4, getBronzePrice());
        addTicketPrices(5, getGeneralAdmissionPrice());
    }
    
    /**
     * Description: Update the ticket prices in the array list. From Raul.
     */
    public void updateTicketPrices(){
        //! update the ticket prices and return the array.

        getTicketPrices().set(0, 0.0);
        getTicketPrices().set(1, getVipPrice());
        getTicketPrices().set(2, getGoldPrice());
        getTicketPrices().set(3, getSilverPrice());
        getTicketPrices().set(4, getBronzePrice());
        getTicketPrices().set(5, getGeneralAdmissionPrice());
    }

    /**
     * Description: Print the ticket prices for the current event. From fernando.
     */
    public void getPrices(){
        // print each price
        System.out.println("VIP Prices: $" + getVipPrice());
        System.out.println("Gold Prices: $" + getGoldPrice());
        System.out.println("Silver Prices: $" + getSilverPrice());
        System.out.println("Bronze Prices: $" + getBronzePrice());
        System.out.println("GA Prices: $" + getGeneralAdmissionPrice());
        try {
            // sleep for 4 seconds or 4 milliseconds
            System.out.println("Processing ...");
            Thread.sleep(4000); // the customer has time to read the prices
        } catch (InterruptedException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: This method gets the ticket prices.  From Walter
     * @param ticketType Holds ticket type.
     * @return The ticket price.
     */
    public double getTicketPrice(String ticketType) {
        double ticketPrice = 0.0;
        //! Find ticket price.
        switch (ticketType.toLowerCase()) {
            case "vip":
                ticketPrice = getVipPrice();
                break;
            case "gold":
                ticketPrice = getGoldPrice();
                break;
            case "silver":
                ticketPrice = getSilverPrice();
                break;
            case "bronze":
                ticketPrice = getBronzePrice();
                break;
            case "general admission":
                ticketPrice = getGeneralAdmissionPrice();
                break;
            default:
                break;
        }
        //! Return ticket price for ticket type.
        return ticketPrice;
    }
}