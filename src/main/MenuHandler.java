package main;
/**
 * Description: This class handles the menus that are printed to the user.
 * @author Extreme Software Development Team LLC
 */
public class MenuHandler{

    /**
     *  Description: Default Constructor
     */
    public MenuHandler(){}



    /**
     * Description: This method prompt how to log in.
     */
    public void chooseLogInMenu(){
        System.out.println("How would you like to log in to TicketMiner?\n1. Username\n2. First and Last name");
        System.out.print(">> ");
    }

    /**
     * Description: This method prints for when a user is buying a ticket
     */
    public void buyTicketMenu(String eventType) {
        //! Clear screen.
        //FlushScreen.flushScreen();
        System.out.println("Please enter the ticket type you want to purchase\n");
        System.out.print(">> ");
    }



    /**
     * Description: This method prints a menu to administrator. How they want to search an event.From Fernando.
     */
    public void typeOfSearchMenu(){
        //! clear screen.
        //FlushScreen.flushScreen();
        //! Print the menu of id or name.
        System.out.println("\nPlease enter a valid option");
        System.out.println("A. Inquire event by ID\nB. Inquire event by name");
        System.out.print(">> ");
    }

    /**
     * Description: This method prints a menu to see if user is an admin or customer or wants to leave.From Raul.
     */
    public void adminModifyMenu(){
        //! clear screen.
        //FlushScreen.flushScreen();
        //! Print menu.
        System.out.println("Please enter valid integer option");
        System.out.println("1: Do you want to modify the contents?");
        System.out.println("2: Do you want to return");
        System.out.print(">> ");
    }

    /**
     * Description: This method prints a menu seen by admins for their choice to view inquiry. From Fernando.
     */
    public void adminInquiryMenu(){
        //! Clear screen.
        //FlushScreen.flushScreen();
        //! Print prompt.
        System.out.println("\nWhat would you like to inquire: ");
        System.out.println("A. All information ");
        System.out.println("B. Total seats remaining ");
        System.out.println("C. VIP seats remaining ");
        System.out.println("D. Gold seats remaining ");
        System.out.println("E. Silver seats remaining ");
        System.out.println("F. Bronze seats remaining ");
        System.out.println("G. General Admission seats remaining ");
        System.out.println("H. Total seats remaining(Excluding reserved) ");
        System.out.println("I. Amount collected from VIP seats sold ");
        System.out.println("J. Amount collected from Gold seats sold ");
        System.out.println("K. Amount collected from Silver seats sold ");
        System.out.println("L. Amount collected from Bronze seats sold ");
        System.out.println("M. Amount collected from General Admission seats sold ");
        System.out.println("N. Amount collected from all seats sold ");
        System.out.println("O. Total Profit expected ");
        System.out.println("P. Current profit ");
        System.out.println("Q. Amount collected from service fees");
        System.out.println("R. Amount collected from convenience fees");
        System.out.println("S. Amount collected from charity fees");
        System.out.println("T. Amount collected from total fees");
        System.out.println("U. View current successful transactions");
        System.out.println("V. Are you Done? Press \"V\"" );
        System.out.print("Choose from A -> V : ");
        
    }

    /**
     * Description: This method prompts admin functionality menu.
     */
    public void printAdminFunctionalityMenu(){
        System.out.println("\n1: View event analytics");
        System.out.println("2: Do auto shopping");
        System.out.println("3: Do team auto shopping");
        System.out.println("4: Add new event");
        System.out.println("5: Cancel an event");
        System.out.println("6: Modify an event");
        System.out.println("7: Obtain Electronic Invoice Summary of specific customer");
        System.out.println("8: Log out of account");
        System.out.print(">> ");
    }

        /**
     * Description: This method prints the admin privileges.From Raul.
     * @param node Holds event details.
     */
    public void AdminPrivilegesMenu(NodeData node){
        //! Clear screen.
        //FlushScreen.flushScreen();

        //! store the event data and ticket data.
        Event eventData = node.getEventData();
        TicketsHandler ticketData = node.getTicketsData();

        //! Print the event details that the admin can modify.
        System.out.println("Event Id: " + eventData.getEventID() );
        System.out.println("1: Name: " + eventData.getEventName());
        System.out.println("2: Date: " + eventData.getDate());
        System.out.println("3: Time: " + eventData.getTime());
        System.out.println("4: Vip price: " + ticketData.getVipPrice());
        System.out.println("5: Gold price: " + ticketData.getGoldPrice());
        System.out.println("6: Silver price: " + ticketData.getSilverPrice());
        System.out.println("7: Bronze price: " + ticketData.getBronzePrice());
        System.out.println("8: General admission price: " + ticketData.getGeneralAdmissionPrice());
    
    }

    /**
     * Description: Prompt to ask user for who they are, either Admin or Customer.
     */
    public void typeOfUserMenu(){
        //! Clear screen.
        //FlushScreen.flushScreen();
        //! Print the prompt of Admin or Customer
        System.out.println("Are you an admin or a customer?"); 
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("3. Exit");
        System.out.print(">> ");
    }

    /**
     * Description: Prompt user the number of tickets they want to buy.From Fernando.
     */
    public void numberOfTicketsMenu(){
        //! Clear screen.
        //FlushScreen.flushScreen();
        //! Print prompt to user.
        System.out.println("How many tickets (1 - 6): ");
        System.out.print(">> ");
    }

    public void ticketMenu() {
        //! Clear screen.
        //FlushScreen.flushScreen();

        //! Print prompt.
        System.out.println("Please enter the ticket type you want to purchase\n");
        System.out.println("1. VIP");
        System.out.println("2. GOLD");
        System.out.println("3. SILVER");
        System.out.println("4. BRONZE");
        System.out.println("5. GA - GENERAL ADMISSION");
        System.out.println("6: No longer want to buy ticket(s)");
        System.out.print(">> ");
    }

    /**
     * Description: Prompt the administrator with choice.From Fernando and Raul.
     */
    public void mainMenu(){
        //! Print prompt.
        //FlushScreen.flushScreen();
        //! Prompt to print to user.
        System.out.println("\nPlease enter valid option");
        System.out.println("Type 'Search' to search for an event");
        System.out.println("Type 'Exit' to exit the menu");
        System.out.print(">> ");
    }

    public void customerMainMenu() {
        System.out.println("\nPlease enter valid option");
        System.out.println("1: To search for an event");
        System.out.println("2: To cancel a ticket(s)");
        System.out.println("3: To log out of account");
        System.out.print(">> ");
    }

    /**
     * Description: Prompt admin what they can change in the event.
     */
    public void modifyMenu(){
        //! Clear screen.
        //FlushScreen.flushScreen();
        //! Print prompt.
        System.out.println("\nTo update contents type number (1 - 8) or type number 9 to exit\n");
    }
    
    /**
     * Description: Prompt admin for date of event.
     */
    public void dateMenu(){
        FlushScreen.flushScreen();
        System.out.println("Please enter time in this formate (MM/DD/YY). Ex: 12/20/2001");
        System.out.print(">> ");
    }

    /**
     * Description: Prompt admin for time of event.
     */
    public void timeMenu(){
        FlushScreen.flushScreen();
        System.out.println("Please enter time in this 12 hour formate (HH:MM). Ex: 11:03");
        System.out.print(">> ");
    }

    /**
     * Description: Prompt admin for name of event.
     */
    public void venueNameMenu(){
        System.out.println("\n1. Sun Bowl Stadium");
        System.out.println("2. Don Haskin Center");
        System.out.println("3. Magoffin Auditorium");
        System.out.println("4. San Jacinto Plaza");
        System.out.println("5. Centennial Plaza");
        System.out.print(">> ");
    }

    /**
     * Description: Prompt admin for name of event.
     */
    public void ticketPriceMenu() {
        System.out.println("General Admission price (no greater than $4000) ");
        System.out.print(">> ");
    }
} 