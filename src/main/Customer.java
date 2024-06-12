package main;


import java.util.*;

/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Customer.java file is used to create Customer objects.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */
public class Customer extends Person{
    private int customerID;
    // private String customerFirstName;
    // private String customerLastName;
    private double customerMoneyAvailable;
    private int customerTicketsPurchased;
    private boolean customerMembership;
    private String customerUsername;
    private String customerPassword;
    private double totalSavings;
    private int transactionCount;
    private double reimbursementAmount;
    private int ticketsCanceled;


    private int invoices = 0;
    
    //! Store the customers, the name, password/username.
    private static HashMap<Integer, Customer> customerMap = new HashMap<>();
    private static HashMap<String, Integer> customerName = new HashMap<>();
    private static HashMap<String, Integer> customerUsernameAndPassword = new HashMap<>();

    private ArrayList<String> ticketsOwned = new ArrayList<>();
    
    //! if customer cancels a ticket.
    private HashMap<Integer, ArrayList<Ticket>> customerTransactions = new HashMap<>();


    //! Only created if their is a customer. From Raul.
    private CustomerLogger customerLogger;


    /**
     * This creates an empty instance of Customer
     * 
     * @param none
     */
    public Customer() {

    }

    /**
     * Description: Constructor, set the customer logger per customers
     * @param customerLogger
     */
    public Customer(CustomerLogger customerLogger){
        setCustomerLogger(customerLogger);
    }


    /**
     * Description: This method prints tickets owned.
     */
    public void printTicketOwned(){
        //! Print tickets owned. if canceled print in red else white.
        for (String invoiceTicket : ticketsOwned) {
            if(invoiceTicket.contains("CANCELED"))
                System.out.println("\u001B[31m" + invoiceTicket + "\u001B[0m");
            else    
                System.out.println(invoiceTicket);
        }
    }

    /**
     * Description:  This method find customer by password and username.
     * @param userName Holds username.
     * @param password Holds password.
     * @return The customer that logged in using password
     */
    public static Customer loggedInPassword(String userName, String password) {
        try {
            //! Key the key ID from the username and password.
            int key = customerUsernameAndPassword.get(userName + " " + password);
            //! Return the customer.
            return customerMap.get(key);
        } catch (Exception e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        //! Return null if username and password was not found.
        return null;
    }



    /**
     *  Description: This method finds customer by first and last name.
     * @param firstName Holds first name.
     * @param lastName Holds last name.
     * @return The customer that logged in using their name
     */
    public static Customer loggedInName(String firstName, String lastName) {
        
        try {
            //! Key the key ID from the full name.
            int key = customerName.get(firstName + " " + lastName);
            //! Return the customer.
            return customerMap.get(key);
            
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        //! Return null if name was not found.
        return null;
    }

    /**
     * Description: Get the reimbursement amount.
     * @return The amount.
     */
    public double getReimbursementAmount() {
        return this.reimbursementAmount;
    }
    /**
     * Description: Set the reimbursement amount.
     * @param reimbursementAmount Holds amount.
     */
    public void setReimbursementAmount(double reimbursementAmount) {
        this.reimbursementAmount += reimbursementAmount; 
    }

    /**
     * Description: Get ticket(s) canceled .
     * @return The number of canceled ticket(s)
     */
    public int getTicketsCanceled() {
        return this.ticketsCanceled;
    }
    /**
     * Description: Set the ticket(s) canceled.
     * @param ticketsCanceled Holds the number of ticket(s) canceled.
     */
    public void setTicketsCanceled(int ticketsCanceled) {
        this.ticketsCanceled = ticketsCanceled;
    }

    /**
     * Description: Get the transaction count.
     * @return The number of transactions.
     */
    public int getTransactionCount() {
        return this.transactionCount;
    }
    /**
     * Description: Set the transaction count.
     * @param transactionCount Holds transaction number.
     */
    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    /**
     * Description: Get the customer ID.
     * @return The customer ID.
     */
    public int getCustomerID() {
        return this.customerID;
    }

    /**
     * Description: Set the customer ID.
     * @param customerID Holds customer ID.
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Description: Get the customer money.
     * @return The customer money.
     */
    public double getCustomerMoneyAvailable() {
        return this.customerMoneyAvailable;
    }

    /**
     * Description: Set the customer money.
     * @param customerMoneyAvailable Holds customer money.
     */
    public void setCustomerMoneyAvailable(double customerMoneyAvailable) {
        this.customerMoneyAvailable = customerMoneyAvailable;
    }

    /**
     * Description: Get the customer tickets purchased.
     * @return The customer tickets purchased.
     */
    public int getCustomerTicketsPurchased() {
        return this.customerTicketsPurchased;
    }

    /**
     * Description: Set the customer tickets purchased.
     * @param customerConcertsPurchased Holds customer tickets purchased.
     */
    public void setCustomerTicketsPurchased(int customerTicketsPurchased) {
        this.customerTicketsPurchased = customerTicketsPurchased;
    }

    /**
     * Description: Get the customer membership.
     * @return The customer membership
     */
    public boolean getCustomerMembership() {
        return this.customerMembership;
    }

    /**
     * Description: Set the customer membership.
     * @param customerMembership Holds customer membership.
     */
    public void setCustomerMembership(boolean customerMembership) {
        this.customerMembership = customerMembership;
    }

    /**
     * Description: Get the customer username.
     * @return The customer username
     */
    public String getCustomerUsername() {
        return this.customerUsername;
    }

    /**
     * Description: Set the customer username.
     * @param customerUsername Holds customer username.
     */
    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    /**
     * Description: Get the customer password.
     * @return The customer password.
     */
    public String getCustomerPassword() {
        return this.customerPassword;
    }

    /**
     * Description: Set the customer password.
     * @param customerPassword Holds customer password.
     */
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    /**
     * Description: Get the total savings.
     * @return The total savings.
     */
    public double getTotalSavings() {
        return this.totalSavings;
    }

    /**
     * Description: Set the total saving.
     * @param totalSavings Holds the total saving.
     */
    public void setTotalSavings(double totalSavings) {
        this.totalSavings += totalSavings;
    }

    /**
     * Description: Get the customer Map.
     * @return The customer hashMap.
     */
    public static HashMap<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    /**
     * Description: Set the customer Map.
     * @param customerMap Holds the customer hashMap.
     */
    public static void setCustomerMap(HashMap<Integer, Customer> customerMap) {
        Customer.customerMap = customerMap;
    }


    /**
     * Description: Get the customer Map.
     * @return The customer hashMap name with ID pairs.
     */
    public static HashMap<String, Integer> getCustomerUsernameAndPassword() {
        return customerUsernameAndPassword;
    }

    /**
     * Description: Set the customer Map.
     * @param customerName Holds the customer name with ID hashMap pairs.
     */
    public static void setCustomerUsernameAndPassword(HashMap<String, Integer> customerUsernameAndPassword) {
        Customer.customerUsernameAndPassword = customerUsernameAndPassword;
    }

    /**
     * Description: Get the customer Map.
     * @return The customer hashMap name with ID pairs.
     */
    public static HashMap<String, Integer> getCustomerName() {
        return customerName;
    }

    /**
     * Description: Set the customer Map.
     * @param customerName Holds the customer name with ID hashMap pairs.
     */
    public static void setCustomerName(HashMap<String, Integer> customerName) {
        Customer.customerName = customerName;
    }

    /**
     * Description: Get the tickets owned.
     * @return The tickets owned.
     */
    public ArrayList<String> getTicketsOwned() {
        return this.ticketsOwned;
    }

    /**
     * Description: Set the tickets owned.
     * @param ticketsOwned holds the tickets owned.
     */
    public void setTicketsOwned(String invoice) {
        this.ticketsOwned.add(invoice);
    }

    /**
     * Description: Get the CustomerLogger object. From Raul.
     * @return The object.
     */
    public CustomerLogger getCustomerLogger() {
        return this.customerLogger;
    }
    /**
     * Description: Set teh CustomerLogger object. From Raul.
     * @param customerLogger Holds the new object.
     */
    public void setCustomerLogger(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    /**
     * Description: Get the customer # invoices.
     * @return The number of invoices.
     */
    public int getInvoices() {
        return this.invoices;
    }

    /**
     * Description: Set the customer # Invoices.
     * @param invoices Holds number of invoices.
     */
    public void setInvoices(int invoices) {
        this.invoices = invoices;
    }
    /**
     * Description: get customer Transactions.
     * @return The transactions.
     */
    public HashMap<Integer, ArrayList<Ticket>> getCustomerTransactions() {
        return customerTransactions;
    }
    /**
     * Description: Set the customer transactions.
     * @param customerTransactions holds transactions data structure.
     */
    public void setCustomerTransactions(HashMap<Integer, ArrayList<Ticket>> customerTransactions) {
        this.customerTransactions = customerTransactions;
    }


    /**
     * Description: A method to print to the screen about the contents of the specified customer.From Raul and Fernando.
     */
    public void printCustomer(){
        //! Print statements for every attribute.
        System.out.println("ID: " + getCustomerID());
        System.out.println("First name: " + getFirstName());
        System.out.println("Last name: " + getLastName());
        System.out.println("money available: " + getCustomerMoneyAvailable());
        System.out.println("Money saved: " + getTotalSavings());
        System.out.println("Concert purchased: " + getCustomerTicketsPurchased());
        System.out.println("TicketMiner membership: " + getCustomerMembership());
        System.out.println("Username: " + getCustomerUsername());
        System.out.println("Password: " + getCustomerPassword());

    }

}
