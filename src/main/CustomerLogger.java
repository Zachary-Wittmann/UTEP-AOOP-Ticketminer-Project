package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * Description: This class is used to log the customer's action.
 * @author Extreme Software Development LLC
 */
public class CustomerLogger {

    //! Holds file name .txt.
    private String fileName;

    //! For accessing logger framework.
    private Logger logger;

    private FileHandler fileHandler;

    /**
     * Description: Default constructor.
     */
    public CustomerLogger(){}


    /**
     * Description: Get the customer logger file name.
     * @return The customer logger file name.
     */
    public String getFileName() {
        return this.fileName;
    }
    /**
     * Description: Set the customer logger file name.
     * @param fileName Holds the name of the customer logger txt.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Description: Get the logger for customer.
     * @return The logger.
     */
    public Logger getLogger() {
        return this.logger;
    }
    /**
     * Description: Set the logger name for customer.
     */
    public void setLogger() {
        this.logger = Logger.getLogger(getFileName() + " " +CustomerLogger.class.getName());
    }


    /**
     * Description: Get the file handler.
     * @return The object
     */
    public FileHandler getFileHandler() {
        return this.fileHandler;
    }

    /**
     * Description: Set file handler.
     * @param fileHandler Holds object.
     */
    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    /**
     * Description: This method sets up a directory for the customers actions.
     */
    public synchronized void configureCustomerDirectory() {
        try {
            //! Get the path and make or open directory.
            File customerLogger = new File("CustomerLoggers");
            customerLogger.mkdir();

            //! Get folder or make folder in directory.
            File customerFile = new File("CustomerLoggers/" + getFileName());
            customerFile.mkdir();

        } catch (Exception e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: THis method sets up the customer logger to track customers actions.
     */
    public synchronized void configureCustomerLogger(){

        try {
            //! Do not write to terminal.
            getLogger().setUseParentHandlers(false);

            //! Get the file specified.
            setFileHandler(new FileHandler("CustomerLoggers/" + getFileName() + "/customer_log.txt", true));
            //! For readability in .txt file.
            getFileHandler().setFormatter(new SimpleFormatter());
            //! Allows us to use config, finer etc.
            getLogger().setLevel(Level.ALL);
            //! Store teh fileHandler to write to file.
            getLogger().addHandler(getFileHandler());
        } catch (Exception e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }


    /**
     * Description: This method Closes file handlers when done.
     */
    public synchronized void closeLogger(){
        //! Run and close file handler.
        if(getFileHandler() != null)
            getFileHandler().close();
    }

    /**
     * Description: This method logs the admin functionality chosen.
     * @param choice Holds the options chosen.
     */
    public synchronized void logCustomerChoice(Customer customer, String choice){
        getLogger().info(customer.getFirstName() + " " + customer.getLastName() +  " selected the option called " + choice + "\n");
    }


    /**
     * Description: This method logs the customers action if they could not afford to buy a ticket.From Raul.
     * @param currentCustomer Holds the data for the current customer.
     * @param eventID Holds the event ID data.
     */
    public synchronized void logCouldNotAffordToFile(Customer currentCustomer, int eventID) {
        try {
            //! Log to .txt file.
            getLogger().info("Customer: " + currentCustomer.getFirstName() + ", " + currentCustomer.getLastName() + " could not afford to buy a ticket for event ID " + eventID + "\n" );   
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
            
    }

    /**
     * Description: This method writes the customers action if they tried to buy tickets, but there were not enough tickets to buy. From Raul.
     * @param currentCustomer Holds current customer data.
     * @param ticketType Holds the type of ticket the customer tried to buy.
     */
    public synchronized void logNotEnoughTicketsToFile(Customer currentCustomer, String ticketType){
        
        try {
            //! Log to .txt file.
            getLogger().info("Customer: " + currentCustomer.getFirstName() + ", " + currentCustomer.getLastName() + " tried to buy " + ticketType + " ticket(s)." +
                            "There was not enough availability of the ticket type.\n");

        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
      * Description: Log customer information to the filename including the payment information. From Fernando.
      * @param currentCustomer Holds the current customer logged in 
      * @param tempEvent Holds the event chosen by the customer
      * @param amount Holds the amount the customer from 1-6 gave to the system
      * @param totalCost Holds the total Cost including any discounts and taxes
      */
        public void logSuccessfulTransaction(Customer currentCustomer, Event tempEvent, int amount, double totalCost){
        try{  
            //! Store information.      
            String customerInfo = currentCustomer.getCustomerLogger().printCustomerLogger(currentCustomer);
            String payment = "Customer payed " + amount + " tickets for $" + totalCost + "\n"; 
            String eventInfo = "EventID: " + tempEvent.getEventID() + "\nEvent Type: " + tempEvent.getEventType() + "\nEvent Name: " + tempEvent.getEventName() + "\nEventTime: " + tempEvent.getDate() + " " + tempEvent.getTime() + "\n";
            //! Write to .txt file.
            getLogger().info(customerInfo + payment + eventInfo + "\n");

        }
        catch(NullPointerException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: This method log what customer is viewing.
     * @param customer Holds customer data.
     * @param eventID Holds the event ID searched.
     */
    public void logViewing(Customer customer, int eventID){
        try {
            getLogger().info(customer.getFirstName() + " " + customer.getLastName() + " viewed event ID " + eventID + "\n");
            
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: This method logs that customer is canceling a ticket(s).
     * @param customer Holds customer data.
     */
    public void logCancelTickets(Customer customer){
        getLogger().info(customer.getFirstName() + " " + customer.getLastName() + " is decided to cancel a ticket");
    }

    /**
     * Description: Get the customer data and store the data in a string variable.
     * @param customer Holds the current customer
     * @return a message of type string
     */
    public  String printCustomerLogger(Customer customer){
        //! Store customer data in string formate and return.
        String message = "";
        try {
            message += "ID: " + customer.getCustomerID() + "\n";
            message += "Customer Name: " + customer.getFirstName() + " " + customer.getLastName() + "\n";
            message += "Customer Username: " + customer.getCustomerUsername() + "\n";
            message += "Customer Password: " + customer.getCustomerPassword() + "\n";
            message += "Available Money: " + customer.getCustomerMoneyAvailable() + "\n";
            message += "Tickets Purchased: " + customer.getCustomerTicketsPurchased() + "\n";
            message += "Has Membership: " + customer.getCustomerMembership() + "\n";
            
        } catch (Exception e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return message;
        
    }   

    /**
     * Description: Method to clear a file of existing contents/data. File is a txt file for customer.
     */
    public  void flushCustomerFile(){
        try {

            //!Get customer file to write to.
            FileOutputStream fileOut = new FileOutputStream("CustomerLoggers/" + getFileName() + "/customer_log.txt");
            
            //! Used to write to the customer file we passed in constructor.
            PrintWriter printWriter = new PrintWriter(fileOut);
            
            //! Clear the contents in the customer file.
            printWriter.println("");
            
            //! Writes data quickly to the customer file.
            printWriter.flush();
            
            //! When done writing to customer file, close fileOutputStream.
            fileOut.close();
            
        } catch (FileNotFoundException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        catch(IOException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }
    
}