package main;
import java.util.Scanner;
/**
 * Description: This class is only for the inquiry options. It's main purpose to identify the admins actions viewing inquiry. Everything in the class and method were refactored and collaborated together via live share.
 * @author Raul Pallares
 * @author Fernnado Remes
 * @author Walter Wawra
 * @author Zachary Wittmann
 * @since 11/2/2023
 */
public class AdminInquiry {
    
    //! Only created if their is an admin for single inquiry.From Raul and Fernando.
    private AdminIndividualInquiry adminIndividualInquiry;
    
    /**
     * Description: Default constructor.
     */
    public AdminInquiry(){}

    /**
     * Description: Constructor, set the admin individual inquiry object.
     * @param adminIndividualInquiry Contain the information from admin individual inquiry.
     */
    public AdminInquiry(AdminIndividualInquiry adminIndividualInquiry){
        setAdminIndividualInquiry(adminIndividualInquiry);
    }

    /**
     * Description: Getter for admin single inquiry object.
     * @return The admin single object object.
     */
    public AdminIndividualInquiry getAdminIndividualInquiry() {
        return this.adminIndividualInquiry;
    }
    /**
     * Description: Setter for admin single inquiry object.
     * @param adminIndividualInquiry Holds data for admin single object.
     */
    public void setAdminIndividualInquiry(AdminIndividualInquiry adminIndividualInquiry) {
        this.adminIndividualInquiry = adminIndividualInquiry;
    }

    /**
     * Description: The multiple choices the admin has for viewing the inquiries. From Raul and Fernando
     * @param genericScanner The scanner for the user to input. 
     * @param node Get the ticket information from event/ venue.
     * @param logger Will log the input from user.
     */
    public void mainMenu(Scanner genericScanner, NodeData node, AdminLogger logger){
        
        //! Try/catch to make sure the NULL exception occurs if needed
        try {
            //! Get the event ID
            int eventID = node.getEventData().getEventID();

            //! Get the ticket rev, seats sold, ticket availability 
            TicketsHandler ticketHandler = node.getTicketsData();
            TicketAnalytics profitAndRevenueHandler = node.getTicketsData().getTicketAnalytics();;

            //! GEt finances
            Finances finances = node.getEventData().getFinances();
            //! Create the menu
            MenuHandler menuHandler = new MenuHandler();

            //! The Scanner options using a while loop
            String input = "";
            while(true){
                
                menuHandler.adminInquiryMenu();

                input = genericScanner.nextLine();
                //! Print all all information
                if(input.equalsIgnoreCase("A")){
                    printEventInquiry(node);
                    System.out.println();

                    logger.logInquiry(input, eventID);
                }
                //! Print seats remaining
                else if(input.equalsIgnoreCase("B")){
                    getAdminIndividualInquiry().printTotalSR(profitAndRevenueHandler);
                    System.out.println();

                    logger.logInquiry(input, eventID);
                }
                //! Print VIP seats remaining 
                else if(input.equalsIgnoreCase("C")){
                    getAdminIndividualInquiry().printVipSR(profitAndRevenueHandler);
                    System.out.println();

                    logger.logInquiry(input, eventID);
                }
                //! Print Gold seats remaining
                else if(input.equalsIgnoreCase("D")){
                    getAdminIndividualInquiry().printGoldSR(profitAndRevenueHandler);
                    System.out.println();

                    logger.logInquiry(input, eventID);
                }
                //! Print Silver seats remaining
                else if(input.equalsIgnoreCase("E")){
                    getAdminIndividualInquiry().printSilverSR(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print Bronze seats remaining
                else if(input.equalsIgnoreCase("F")){
                    getAdminIndividualInquiry().printBronzeSR(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the General Admission remaining seats
                else if(input.equalsIgnoreCase("G")){
                    getAdminIndividualInquiry().printGeneralSR(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the total amount of seats remaining excluding reserved seats
                else if(input.equalsIgnoreCase("H")){
                    getAdminIndividualInquiry().printTotalSeatsExRsv(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the amount of Vip Tickets
                else if(input.equalsIgnoreCase("I")){
                    getAdminIndividualInquiry().printVIPCollected(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the amount of Gold Tickets
                else if(input.equalsIgnoreCase("J")){
                    getAdminIndividualInquiry().printGoldCollected(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the amount of Silver Tickets
                else if(input.equalsIgnoreCase("K")){
                    getAdminIndividualInquiry().printSilverCollected(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the amount of Bronze Tickets
                else if(input.equalsIgnoreCase("L")){
                    getAdminIndividualInquiry().printBronzeCollected(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the amount of General Admission Tickets
                else if(input.equalsIgnoreCase("M")){
                    getAdminIndividualInquiry().printGeneralCollected(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the total amount of Tickets
                else if(input.equalsIgnoreCase("N")){
                    getAdminIndividualInquiry().printTotalCollected(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //!  Print the expected profits
                else if(input.equalsIgnoreCase("O")){
                    getAdminIndividualInquiry().printExpectedProfit(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the current profits
                else if(input.equalsIgnoreCase("P")){
                    getAdminIndividualInquiry().printCurrentProfit(profitAndRevenueHandler);
                    System.out.println();
                    logger.logInquiry(input, eventID);
                }
                //! Print the Service fees
                else if (input.equalsIgnoreCase("Q")){
                    System.out.printf("Total Service Fees: $%.2f\n", finances.getTotalServiceFee());
                    logger.logInquiry(input, eventID);
                }
                //! Print the Convenience fees
                else if (input.equalsIgnoreCase("R")){
                    System.out.printf("Total Convenience Fees: $%.2f\n", finances.getTotalConvenienceFee());
                    logger.logInquiry(input, eventID);
                }
                //! Print the charity fees
                else if (input.equalsIgnoreCase("S")){
                    System.out.printf("Total Charity Fees: $%.2f\n", finances.getTotalCharityFee());
                    logger.logInquiry(input, eventID);
                }
                //! Print total fess.
                else if (input.equalsIgnoreCase("T")){
                    System.out.printf("Total Fees: $%.2f\n", finances.getTotalFees());
                    logger.logInquiry(input, eventID);
                }
                //! Print all purchases made for event.
                else if(input.equalsIgnoreCase("U")){
                    node.getEventData().printTickets();
                }
                //! Want to exit.
                else if(input.equalsIgnoreCase("V")){
                    break;
                }
                //! if all else fails then invalid input
                else{
                    System.out.println("Invalid input\n");
                    input = "";
                }
                Thread.sleep(4000);
            }
        } 
        catch(InterruptedException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }

        
    }


    /**
     * Description: Prints the information of the event that is only for admins. From Raul and Fernando.
     * @param node Holds the information of event, venue, and tickets.
     */
    public void printEventInquiry(NodeData node){
        try {
            //! Clear screen.
            FlushScreen.flushScreen();

            Event eventData = node.getEventData();
            Venue venueData = node.getEventData().getVenue();
            Finances finance = node.getEventData().getFinances();
            TicketAnalytics profitAndRevenueHandler = node.getTicketsData().getTicketAnalytics();

            //! Print event details.
            System.out.println("\nEvent ID: " + eventData.getEventID());
            System.out.println("Event name: " + eventData.getEventName());
            System.out.println("Event time: " + eventData.getTime());
            System.out.println("Event date: " + eventData.getDate());
            System.out.println("Event type: " + eventData.getEventType());
            System.out.println("Event capacity: " + venueData.getVenueCapacity());

            //! Print available ticket details.
            System.out.println("Total tickets available: " + (profitAndRevenueHandler.getNumTicketsRemaining() + profitAndRevenueHandler.getNumReservedExtraTickets()));
            System.out.println("Total vip tickets available: " + profitAndRevenueHandler.getNumVipTickets());
            System.out.println("Total gold tickets available: " + profitAndRevenueHandler.getNumGoldTickets());
            System.out.println("Total silver tickets available: " + profitAndRevenueHandler.getNumSilverTickets());
            System.out.println("Total bronze tickets available: " + profitAndRevenueHandler.getNumBronzeTickets());
            System.out.println("Total general admission tickets available: " + profitAndRevenueHandler.getNumGeneralAdmissionTicket());
            System.out.println("Total tickets available (Excluding reserved): " + profitAndRevenueHandler.getNumTicketsRemaining());

            //! Print sold ticket details.
            System.out.println("Total seats sold: " + profitAndRevenueHandler.getTotalSeatsSold());
            System.out.println("Total Vip seats sold: " + profitAndRevenueHandler.getTotalVipSeatsSold());
            System.out.println("Total gold seats sold: " + profitAndRevenueHandler.getTotalGoldSeatsSold());
            System.out.println("Total silver seats sold: " + profitAndRevenueHandler.getTotalSilverSeatsSold());
            System.out.println("Total bronze seats sold: " + profitAndRevenueHandler.getTotalBronzeSeatsSold());
            System.out.println("Total general admission seats sold: " + profitAndRevenueHandler.getTotalGeneralSeatsSold());

            //! Print revenue details
            System.out.printf("Total revenue for vip tickets: $%.2f %n" ,profitAndRevenueHandler.getTotalVipTicketsRevenue());
            System.out.printf("Total revenue for gold tickets: $%.2f %n" , profitAndRevenueHandler.getTotalGoldTicketsRevenue());
            System.out.printf("Total revenue for silver tickets: $%.2f %n" , profitAndRevenueHandler.getTotalSilverTicketsRevenue());
            System.out.printf("Total revenue for bronze tickets: $%.2f %n" , profitAndRevenueHandler.getTotalBronzeTicketsRevenue());
            System.out.printf("Total revenue for general admission tickets: $%.2f %n" , profitAndRevenueHandler.getTotalGeneralTicketsRevenue());

            System.out.printf("Total revenue for all tickets: $%.2f %n", profitAndRevenueHandler.getTotalRevenueAllTickets());
            System.out.printf("Expected profit: $%.2f %n", profitAndRevenueHandler.getExpectedProfit());
            System.out.printf("Actual profit: $%.2f %n", profitAndRevenueHandler.getActualProfit());

            //! Print event fees
            System.out.printf("Total Service Fees: $%.2f\n", finance.getTotalServiceFee());
            System.out.printf("Total Convenience Fees: $%.2f\n", finance.getTotalCharityFee());
            System.out.printf("Total Charity Fees: $%.2f\n", finance.getTotalCharityFee());
            System.out.printf("Total Fees: $%.2f\n", finance.getTotalFees());
            
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }

    }

}
