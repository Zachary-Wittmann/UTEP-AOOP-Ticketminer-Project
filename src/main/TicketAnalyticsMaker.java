package main;

/**
 * @author Zachary Wittmann
 * @author Walter Wawra
 * @since October 8, 2023
 *        CS 3331
 *        Dr. Mejia
 *        Programming Assignment 2
 *        Description: The EventAnalyticsMaker.java file is used to create the
 *        different event analytics for the administrator to view.
 *        Honesty Statement: All code written in this file was done by Zachary
 *        Wittmann and Walter Wawra
 *        without any help from outside sources apart from the instructor and
 *        his assistants.
 */

public class TicketAnalyticsMaker {


    /**
     * Creates analytics for each of the events based off of the seats available and the profits
     * @param venue Holds venue data.
     * @param ticketsHandler Holds ticket object data.
     * @return The ticketAnalytic object.
     */
    public static TicketAnalytics createAnalytics(Venue venue, TicketsHandler ticketsHandler) {

        TicketAnalytics ticketAnalytics = null;
        try {
            //! Calculate the seat availability for each ticket type per event.
            int unavailableSeats =  calculateSeats(venue.getPctSeatsUnavailable(), venue.getVenueCapacity());
            int vipSeats = calculateSeats(venue.getVipPct(), venue.getVenueCapacity() - unavailableSeats);
            int goldSeats = calculateSeats(venue.getGoldPct(), venue.getVenueCapacity() - unavailableSeats);
            int silverSeats = calculateSeats(venue.getSilverPct(), venue.getVenueCapacity() - unavailableSeats);
            int bronzeSeats = calculateSeats(venue.getBronzePct(), venue.getVenueCapacity() - unavailableSeats);
            int generalSeats = calculateSeats(venue.getGeneralPct(), venue.getVenueCapacity() - unavailableSeats);
            int reservedSeats = calculateSeats(venue.getReservedExtraPct(), venue.getVenueCapacity() - unavailableSeats);
    
            //! Set the number of total tickets.
            int numTickets = unavailableSeats + vipSeats + goldSeats + silverSeats + bronzeSeats + generalSeats + reservedSeats;
    
            //! Calculate the expected profit to be made for the event. (sell out).
            double expectedProfit = ((vipSeats * ticketsHandler.getVipPrice()) + (goldSeats * ticketsHandler.getGoldPrice())
                            + (silverSeats * ticketsHandler.getSilverPrice()) + (bronzeSeats * ticketsHandler.getBronzePrice())
                            + (generalSeats * ticketsHandler.getGeneralAdmissionPrice()) - venue.getVenueCost() - venue.getFireworksCost());
    
            //! Initial profit is negative.
            double actualProfit = (-venue.getVenueCost() - venue.getFireworksCost());
            
            //! Store the ticket Analytics.
            ticketAnalytics = new TicketAnalytics(numTickets,reservedSeats,unavailableSeats, vipSeats, goldSeats, silverSeats,bronzeSeats, generalSeats, expectedProfit, actualProfit); 
        } catch (Exception e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        //! Return the ticket analytics objects for the event.
        return ticketAnalytics;
    }

    /**
     * Description: This method calculates seats available.
     * @param pct Holds pct number.
     * @param venueCapacity Holds venue capacity.
     * @return The seats available.
     */
    public static int calculateSeats(int pct, int venueCapacity){
        //! Return tickets available.
        return ((venueCapacity) * (pct) / 100);
    }
}