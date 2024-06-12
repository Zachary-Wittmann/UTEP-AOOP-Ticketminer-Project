package main;
import java.util.Scanner;
/**
 * Description: Runs the main logic of whether user or admin.
 * @author Extreme Software Development Team
 * @since 11/02/2023
 */
public class DoMainProgram {

    /**
     * Description: Default, Constructor.
     */
    public DoMainProgram(){}


    Person person = null;

    public void runProgramLogic(){

        try {
            MenuHandler menuHandler = new MenuHandler();
            AdminOrCustomer adminOrCustomer = new AdminOrCustomer();
            UserInputHandler userInputHandler = new UserInputHandler();
    
    
            while (true) {
                
                System.out.println(Logos.mainLogo());
                menuHandler.typeOfUserMenu();
                int typeUser = adminOrCustomer.chooseAdminOrCustomer();
        
        
                if(typeUser == 1){
        
                    //! Create admin.
                    person = new Admin(new AdminEventModifier(), new AdminLogger("AdminLogger.txt"), new AdminInquiry(new AdminIndividualInquiry()));      
                    Admin admin = (Admin) person;
                    //! Create directory to log admin actions.
                    admin.getAdminLogger().configureAdminDirectory();
                    admin.getAdminLogger().configureAdminLogger();
        
                    //! As log as admin wants.
                    while (true) {
                        //! Prompt admin choice.
                        menuHandler.printAdminFunctionalityMenu();
                        int adminChoice = userInputHandler.isInRange(new Scanner(System.in), 1, 8);
                        //! Do admin log and save if admin wants to log out, if so exit, else prompt logic again.
                        int isExit = adminLogic(adminChoice, menuHandler, userInputHandler, admin);
                        //! Wants to exit.
                        if(isExit == 8){
                            //! Done with logging admin.
                            admin.getAdminLogger().closeLogger();
                            break;
                        }    
                    }
                }
                if(typeUser == 2){
        
                    Login login = new Login();
        
                    person =  login.chooseLogIn(new Scanner(System.in), menuHandler, userInputHandler);
                    
                    Customer customer = (Customer) person;
        
                    customer.getCustomerLogger().configureCustomerDirectory();
                    customer.getCustomerLogger().configureCustomerLogger();
        
                    //! As log as customer is logged in.
                    while(true){
                        System.out.println(Logos.menuLogo());
                        //! Prompt customer main menu.
                        menuHandler.customerMainMenu();
                        //! Get choice to do.
                        int customerChoice = userInputHandler.isInRange(new Scanner(System.in), 1, 3);
                        
                        //! Search and potentially buy.
                        if(customerChoice == 1){
            
                            while(true){
                                //! Get the event to buy.
                                NodeData node = doSearch(menuHandler,userInputHandler);
            
                                //! Show customer the event and log action.
                                node.getEventData().printEventData(node.getTicketsData());
                                customer.getCustomerLogger().logViewing(customer, node.getEventData().getEventID());
            
                                //! Do ticket Logic.
                                menuHandler.ticketMenu();
                                //! Get ticket package choice.
                                int ticketChoice = userInputHandler.isInRange(new Scanner(System.in), 1, 6);
                                
                                //! DO not want to buy ticket any more, prompt if want to search again or exit.
                                if(ticketChoice == 6){
                                    customer.getCustomerLogger().logCustomerChoice(customer, "No longer want to buy ticket(s)");
                                    System.out.println("You did not want to buy a ticket(s).");
                                } else{
                                    customer.getCustomerLogger().logCustomerChoice(customer, " wants to buy ticket(s)");
                                    //! Get amount of tickets
                                    menuHandler.numberOfTicketsMenu();
                                    int ticketQuantity = userInputHandler.isInRange(new Scanner(System.in), 1, 6);
                                    
                                    //! Do shopping logic.
                                    DoShopping doShopping = new DoShopping();
                                    node.getTicketsData().setTicketNames();
                                    //! Do transaction.
                                    doShopping.shopping(node, customer, ticketQuantity, node.getTicketsData().getTicketNames().get(ticketChoice));
                                }
                                System.out.println("Do you want to search again? (Yes/No)");
                                System.out.print(">> ");
                                String continueSearch = userInputHandler.getYesNoInput(new Scanner(System.in));
                
                                if(continueSearch.equalsIgnoreCase("NO"))
                                    break;
                            }
                        } //! Cancel Ticket(s).
                        else if (customerChoice == 2){
                            //! Cancel ticket(s) logic.
                            CancelTicket cancelTicket = new CancelTicket();
                            cancelTicket.cancelTicket(customer);
                            customer.getCustomerLogger().logCancelTickets(customer);
                        }//! Log out of customer. 
                        else if(customerChoice == 3){
                            System.out.println("Goodbye " + customer.getFirstName() + " " + customer.getLastName());
                            customer.getCustomerLogger().logCustomerChoice(customer, "Log out");
                            customer.getCustomerLogger().closeLogger();
                            break;
                        }         
                    }
                }
                if(typeUser == 3){
                    System.out.println("Thank you for using Ticket Miner system.");
                    System.out.println(Logos.exitingLogo());
                    break;
                }
            }
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(ArrayIndexOutOfBoundsException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /** 
     * Description: This method is for admin only and does admin logic/ functionality.
     * @param adminChoice Holds what admin wants to do.
     * @param menuHandler Holds menu object for prompts.
     * @param userInputHandler Holds input logic for user input.
     * @param admin Holds the admin object.
     * @return The int of if admin wants to log out.
     */
    public int adminLogic(int adminChoice, MenuHandler menuHandler, UserInputHandler userInputHandler, Admin admin){
        
        //! For checking if admin wants to log out.
        int isExit = -1;
        try {
            switch (adminChoice) {
                //! D0 analytics.
                case 1:
                    System.out.println("Find event to view analytics");
                    NodeData node = doSearch(menuHandler, userInputHandler);
                    admin.getAdminInquiry().mainMenu(new Scanner(System.in), node, admin.getAdminLogger());
                    admin.getAdminLogger().logAdminChoice("View analytics");
                    break;
                //! Do 100 auto purchases.
                case 2:
                    AutoPurchaser autoPurchaser = new AutoPurchaser();
                    autoPurchaser.doAutoShopping(autoPurchaser.readAutoPurchaserCSV("AutoPurchase100.csv"));
                    admin.getAdminLogger().logAdminChoice("Do auto purchasing");
                    break;
                //! Do team auto purchases.
                case 3:
                    AutoPurchaser autoPurchaser2 = new AutoPurchaser();
                    autoPurchaser2.doAutoShopping(autoPurchaser2.readAutoPurchaserCSV("AutoPurchase8.csv"));
                    admin.getAdminLogger().logAdminChoice("Do team auto purchasing");
                    break;
                //! Do add event.
                case 4:
                    EventAdder eventAdder = new EventAdder(new EventFactory(), new VenueFactory(), new TicketsHandler());
                    eventAdder.addEvent();
                    admin.getAdminLogger().logAdminChoice("Add new event");
                    break;
                //! Do cancel event.
                case 5:
                    System.out.println("Find event to cancel");
                    NodeData node3 = doSearch(menuHandler, userInputHandler);
    
                    CancelEvent cancelEvent = new CancelEvent();
                    cancelEvent.reimbursements(node3);
                    admin.getAdminLogger().logAdminChoice("Cancel and event");
                    break;
                //! Do modify event.
                case 6:
                    System.out.println("Find event to modify");
                    NodeData node2 = doSearch(menuHandler, userInputHandler);
                    AdminEventModifier  adminEventModifier= new AdminEventModifier();
                    adminEventModifier.selectedToModify(node2, admin.getAdminLogger());
                    admin.getAdminLogger().logAdminChoice("Modify an existing event");
                    break;
                //! DO find invoice of customer.
                case 7:
                    findCustomerInvoice();
                    admin.getAdminLogger().logAdminChoice("Find invoice of customer");
                    break;
                //! Do log out.
                case 8:
                    System.out.println("Goodbye, Admin");
                    admin.getAdminLogger().logAdminChoice("Logging out of admin system");
                    isExit = 8;
                    break;
                default:
                    break;
            }
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } finally{
            return isExit;
        }
    }

    /**
     * Description: searches for event
     * @param menuHandler
     * @param userInputHandler
     */
    public NodeData doSearch( MenuHandler menuHandler, UserInputHandler userInputHandler){
    
    
        try {
            menuHandler.typeOfSearchMenu();
            //! Prompt user input. 1--> ID, 2-> name.
            String userSearch = userInputHandler.inquiryHandler(new Scanner(System.in));

            //! Create search, to search by ID or name.
            SearchEvent searchEvent = new SearchEvent();

            //! Return the event data.
            return searchEvent.eventSearch(userSearch, userInputHandler);  
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return null;
    }

    /**
     * Description: Find the customer invoice.
     * @return either null or tickets owned by customers
     */
    public void findCustomerInvoice() {
        System.out.println("Enter customer ID: ");
        System.out.print(">> ");
        UserInputHandler inputHandler = new UserInputHandler();
        int customerID = inputHandler.isValidInteger(new Scanner(System.in));
        Customer customer = Customer.getCustomerMap().get(customerID);
        if (customer.getTicketsOwned().isEmpty()) {
            System.out.println("No tickets owned by customer ");
            return;
        }
        for (String ticket : customer.getTicketsOwned()) {
            System.out.println(ticket);
        }
    }
}