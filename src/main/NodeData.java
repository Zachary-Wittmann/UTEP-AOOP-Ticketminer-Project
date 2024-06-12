package main;
/**
 * Description: This class is used to create a node for the linked list it will hold (event data, venue data, ticket data) in one node. Class came from Raul.
 * @author Raul Pallares
 * @since 10/12/2023
 */
public class NodeData {
    
    //! Attributes to hold event, venue and tickets information.
    private Event eventData;
    private TicketsHandler ticketsData;

    /**
     * Description: Default constructor.
     */
    public NodeData(){}

    /**
     * Description: Constructor that sets the associated event and sets next to null.
     * @param eventData Holds event details
     * @param tickets Holds ticket details
     */
    public NodeData(Event eventData, TicketsHandler tickets){
        //! Set the event data, venue data, ticket data and next.
        setEventData(eventData);
        setTicketsData(tickets);
    }
    
    /**
     * Description: Gets the Event data.
     * @return The event details
     */
    public Event getEventData() {
        return this.eventData;
    }
    /**
     * Description: Sets te Event data.
     * @param eventData Set event details
     */
    public void setEventData(Event eventData) {
        this.eventData = eventData;
    }

    /**
     * Description: Get the ticket information for event/venue.
     * @return The ticket details
     */
    public TicketsHandler getTicketsData() {
        return this.ticketsData;
    }
    /**
     * Description: Set the TicketHandler information for event/venue.
     * @param ticketsData Sets the TicketHandler details
     */
    public void setTicketsData(TicketsHandler ticketsData) {
        this.ticketsData = ticketsData;
    }
}
