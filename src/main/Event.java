package main;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description: This is an abstract class that has Event data. Class from Raul.
 * This class will let its children (Concert, Sport, Festival) store the appropriated data from the excel file of eventList
 * @author Extreme Software Development LLC
 * @since 10/12/2023
 */
public abstract class Event {

    //! Attributes for an event.
    private int eventID;
    private String eventName;
    private String eventType;
    private String date;
    private String time;
    private boolean isCanceled = false;

    // ArrayList of events purchased
    private ArrayList<String> ticketsPurchasedArray = new ArrayList<>();
    // hashmap for tickets purchased for specific event
    private static HashMap<Integer, ArrayList<Ticket>> ticketOwned = new HashMap<>();

    //! Store venue data.
    private Venue venue;
    //! Store finances data.
    private Finances finances;

    /**
     * Description: This method prints the tickets purchased for the event. Stores invoices.
     */
    public void printTicketOwned(){
        //! Run through invoices and print them. If event or ticket canceled print in red.
        for (String invoiceTicket : ticketsPurchasedArray) {
            if(invoiceTicket.contains("CANCELED"))
                System.out.println("\u001B[31m" + invoiceTicket + "\u001B[0m");
            else    
                System.out.println(invoiceTicket);
        }
    }

    /**
     * Description: Get the ticket array containing tickets purchased.
     * @return The array of tickets per event.
     */
    public ArrayList<String> getTicketsPurchasedArray() {
        return this.ticketsPurchasedArray;
    }
    /**
     * Description: Set the tickets purchased invoices.
     * @param ticketsPurchased Holds invoiced data.
     */
    public void setTicketsPurchasedArray(String ticketsPurchased) {
        getTicketsPurchasedArray().add(ticketsPurchased);
    }

    /**
     * Description: Print the tickets purchased for the event.
     * @return prints the tickets purchased for the event.
     */
    public void printTickets(){
        if(!ticketsPurchasedArray.isEmpty()){
            for (String ticketsPurchased : ticketsPurchasedArray) {
                    System.out.println(ticketsPurchased);
            }
        }else{
            System.out.println("There is no purchases made for this event.");
        }
    }

    /**
     * Description: Get the event type for the event.
     * @return The event type
     */
    public String getEventType() {
        return this.eventType;
    }
    /**
     * Description: Set the event type for the event.
     * @param eventType Sets the event type
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * Description: Get the event ID for the event.
     * @return The event ID
     */
    public int getEventID() {
        return this.eventID;
    }
    /**
     * Description: Set the event ID for the event.
     * @param eventID Sets the event ID
     */
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     * Description: get the event name for the event.
     * @return Gets the event name
     */
    public String getEventName() {
        return this.eventName;
    }
    /**
     * Description: Set the event name for the event.
     * @param eventName Sets the event name
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Description: Get the date for the event.
     * @return The data for the specified event
     */
    public String getDate() {
        return this.date;
    }
    /**
     * Description: Set the date for the event.
     * @param date Set the data
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Description: Get the time for the event.
     * @return The time for the event
     */
    public String getTime() {
        return this.time;
    }
    /**
     * Description: Set the time for the event.
     * @param time Set time
     */
    public void setTime(String time) {
        this.time = time;
    }

    
    /**
     * Description: Get the venue object.
     * @return the venue object
     */
    public Venue getVenue() {
        return this.venue;
    }
    /**
     * Description: Set the venue object.
     * @param venue Holds venue data.
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     * Description: Get the finances object.
     * @return
     */
    public Finances getFinances() {
        return this.finances;
    }

    /**
     * Description: Get the boolean is canceled.
     * @return true or false if event is canceled.
     */
    public boolean getIsCanceled() {
        return this.isCanceled;
    }
    /**
     * Description: Set the boolean is canceled. 
     * @param isCanceled Holds true or false for if event is canceled.
     */
    public void setIsCanceled(boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    /**
     * Description: Set the finances object.
     * @param finances
     */
    public void setFinances(Finances finances) {
        this.finances = finances;
    } 

    /**
     * Description: Get the ticketOwned.
     * @return TicketOwned.
     */
    public static HashMap<Integer, ArrayList<Ticket>> getTicketOwned() {
        return ticketOwned;
    }
    /**
     * Description: Set the ticketOwned.
     * @param ticketOwned Holds hashMap data structure.
     */
    public static void setTicketOwned(HashMap<Integer, ArrayList<Ticket>> ticketOwned) {
        Event.ticketOwned = ticketOwned;
    }

    /**
     * Description: Prints the Event data contents to screen.
     * @param ticketData Holds the information of tickets for the event
     */
    public void printEventData(TicketsHandler ticketData){


        try {
            //!  Print the data of event.
            System.out.println("\nEvent ID: " + getEventID());
            System.out.println("Event Name: " + getEventName());
            System.out.println("Event Type: " + getEventType());
            System.out.println("Date: " + getDate());
            System.out.println("Time: " + getTime());
            System.out.println("Vip price: $" + ticketData.getVipPrice());
            System.out.println("Gold price: $" + ticketData.getGoldPrice());
            System.out.println("Silver price: $" + ticketData.getSilverPrice());
            System.out.println("Bronze price: $" + ticketData.getBronzePrice());
            System.out.println("General admission price: $" + ticketData.getGeneralAdmissionPrice());
    
            //! Print fireworks if planned or not.
            if(getVenue().getFireworksPlanned())
                System.out.println("Fireworks planned: Yes");
            else
                System.out.println("Fireworks planned: No");
            //! Print total cost for venue/event.
            System.out.println("Total cost: " + (getVenue().getVenueCost() + getVenue().getFireworksCost()));
        } catch (Exception e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }

    }

}
