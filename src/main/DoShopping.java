package main;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description: Runs the main logic of a customer purchasing a ticket
 * @author Extreme Software Development Team
 * @since 11/02/2023
 */
public class DoShopping {
    
    /**
     * Description: This method does the auto purchase of a customer.
     * @param nodeData Holds event data.
     * @param customer Holds customer data.
     * @param ticketQuantity holds amount of tickets.
     * @param ticketType Holds ticket type.
     */
    public void shopping(NodeData nodeData, Customer customer, int ticketQuantity, String ticketType) {

        try {
            //!  Store the ticket analytics data for easier access.
            TicketAnalytics tickets = nodeData.getTicketsData().getTicketAnalytics();
            TicketsHandler ticketsHandler = nodeData.getTicketsData();

            //! Check if there is enough seats available.
            if (hasEnoughSeats(ticketType, ticketQuantity, tickets)) {
                //! Get new computed total price from sales tax.
                double total = calculateFinances(customer, nodeData, ticketsHandler, ticketType, ticketQuantity);
                //! Check if the customer has enough money to buy ticket.
                if (hasEnoughMoney(customer, total)) {
                    //! Finish transaction, print invoice, update the customer and update the event.
                    printAndStoreInvoice(customer, nodeData, total, ticketType, ticketQuantity);
                    updateCustomer(customer, total, ticketQuantity);
                    updateEvent(nodeData, ticketQuantity, total, ticketType);
                    //! Log the transaction action
                    customer.getCustomerLogger().logSuccessfulTransaction(customer, nodeData.getEventData(), ticketQuantity, total);
                }else{
                    System.out.println("Sorry, You do not have enough money available");
                    //! Log customer action.
                    customer.getCustomerLogger().logCouldNotAffordToFile(customer, nodeData.getEventData().getEventID());
                }    
            } else{
                System.out.println("Sorry, not enough tickets available");
                //! Log customer action.
                customer.getCustomerLogger().logNotEnoughTicketsToFile(customer, ticketType);
            }
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } 
    }


    /**
     * Description: This method calculates sales tax( discount and tax).
     * @param customer HOlds customer data.
     * @param event Holds event data.
     * @param ticketsHandler Holds ticket object data.
     * @param ticketType Holds ticket type.
     * @param ticketQuantity Holds amount of tickets.
     * @return The new price.
     */
    public double calculateFinances(Customer customer, NodeData nodeData, TicketsHandler ticketsHandler, String ticketType, int ticketQuantity){
        //! call in sales tax class to handle getting sales tax, discount prices
        Finances finances = nodeData.getEventData().getFinances();
        //! subtotal = ticket price * quantity 
        double subtotal = ticketsHandler.getTicketPrice(ticketType) * ticketQuantity;
        //! Store discount and tax total.
        double discountPrice = subtotal;

        //! check member ship status. If so apply discount, and save how much saved.
        if (customer.getCustomerMembership()) {
            //! Get new discounted price.
            discountPrice = subtotal * (1 - finances.getDiscount());
        }

        double serviceFee =  finances.calculateServiceFee(ticketQuantity);
        double charityFee = finances.calculateCharityFee(ticketQuantity);

        double totalFee = serviceFee + charityFee + finances.getConvenienceFee();

        //! get the total to include sales tax
        double totalPurchaseCost = (discountPrice + totalFee ) * (1 + finances.getSalesTax());
        //! check if customer has enough money
        if (hasEnoughMoney(customer, totalPurchaseCost)) {
                //! update customer  total saving data
                customer.setTotalSavings(customer.getTotalSavings() + (subtotal - discountPrice));

                //! update money discounted for event
                finances.setTotalDiscounted(finances.getTotalDiscounted() +  subtotal - discountPrice);
                //! it would just be the discounted price right?
                finances.setTotalTax((finances.getTotalTax() + totalPurchaseCost - discountPrice));
                //! Store all fees.
                finances.setTotalFees(finances.getTotalFees() + totalFee);

                //! Store each fee total type.
                finances.setTotalServiceFee(finances.getTotalServiceFee() + serviceFee);
                finances.setTotalCharityFee(finances.getTotalCharityFee() + charityFee);
                finances.setTotalConvenienceFee(finances.getTotalConvenienceFee() + finances.getConvenienceFee());

                //! store for all events.
                Finances.setTotalServiceFeeForAllEvents(Finances.getTotalServiceFeeForAllEvents() + serviceFee);
                Finances.setTotalConvenienceFeeForAllEvents(Finances.getTotalConvenienceFeeForAllEvents() + finances.getConvenienceFee());
                Finances.setTotalCharityFeeForAllEvents(Finances.getTotalCharityFeeForAllEvents() + charityFee);
                Finances.setTotalFeesForAllEvent(charityFee + serviceFee + finances.getConvenienceFee());

                //! Call method to create and store ticket object.
                createTicket(customer,nodeData, subtotal, totalPurchaseCost, serviceFee, finances.getConvenienceFee(), charityFee, ticketType,ticketQuantity,(subtotal - discountPrice));

                //! Return the new price.
                return totalPurchaseCost;
        }else{
            //! return new price, let who ever called method handle the return.
            return totalPurchaseCost;
        }        
    } 



    public void createTicket(Customer customer ,NodeData node, double subTotal, double ticketTotalCost, double serviceFee, double convenienceFee, double charityFee, String ticketType, int ticketQuantity, double totalSaved){

        //! Get event hashMap to store ticket objects.
        HashMap<Integer, ArrayList<Ticket>> eventTicketOwned =  Event.getTicketOwned();
        //! Get customer hashMap to store tickets object.
        HashMap<Integer, ArrayList<Ticket>> customerTicketsOwned = customer.getCustomerTransactions();
        
        //! Store the event and customer ID.
        int eventID = node.getEventData().getEventID();
        int customerID = customer.getCustomerID();
        
        //! Get singleton object to do confirmation number for a customer.
        CustomerConfirmation customerConfirmation = CustomerConfirmation.getInstance();

        //! Holds the confirmation number.
        String confirmationNNumber = customerConfirmation.hashCode(customer, node, ticketType) +  (customer.getCustomerMembership() ? "IM" : "NM") + customer.getCustomerTicketsPurchased();

        //! Create and hold the ticket.
        Ticket ticket = TicketMaker.createTicket(eventID, customerID, subTotal, ticketTotalCost, serviceFee, convenienceFee, charityFee, ticketType, ticketQuantity, confirmationNNumber, totalSaved);

        //! Check if hashMap has key, if so add ticket object to exiting array list for event. Else create a new array and add it to the hashMap value.
        if(eventTicketOwned.containsKey(eventID)){
            ArrayList<Ticket> ticketArray = eventTicketOwned.get(eventID);
            ticketArray.add(ticket);
        }else{
            ArrayList<Ticket> ticketArray = new ArrayList<>();
            ticketArray.add(ticket);
            eventTicketOwned.put(eventID, ticketArray);
        }
        //! Check if hashMap for customer has key, If so add ticket object, else create new array and add ticket object.
        if(customerTicketsOwned.containsKey(eventID)) {
            ArrayList<Ticket> customerTicketArray = customerTicketsOwned.get(eventID);
            customerTicketArray.add(ticket);
        }else{
            ArrayList<Ticket> customerTicketArray = new ArrayList<>();
            customerTicketArray.add(ticket);
            customerTicketsOwned.put(eventID, customerTicketArray);
        }
    }



    /**
     * Description: This method is used to print and store teh invoice per customer.
     * @param customer Holds customer data.
     * @param nodeData Holds event data.
     * @param totalCost Holds the amount paid.
     * @param ticketOption Holds the ticket type.
     */
    public void printAndStoreInvoice(Customer customer, NodeData nodeData, double totalCost, String ticketType,int ticketQuantity){
        //! Create new object of invoice per customer.
        Invoice invoice = new Invoice();
        //! Store event data.
        Event event = nodeData.getEventData();
        //! Get the invoice to print.
        String customerInvoice = invoice.getInfo(customer, nodeData, totalCost, ticketType, ticketQuantity);
        //! Print invoice transaction for customer.
        System.out.println(customerInvoice);


        //! Store invoice to event.
        event.setTicketsPurchasedArray(customerInvoice);

        // update tickets owned
        customer.setTicketsOwned(customerInvoice);
        //! Create folders for customer
        invoice.customerInvoiceCreator(customer, customerInvoice);
    }

    /**
     * Description: This method updates customer data.
     * @param customer Holds customer data.
     * @param totalCost Holds cost.
     * @param quantity Holds amount of tickets.
     */
    public void updateCustomer(Customer customer, double totalCost, int quantity){
        //! Update customer data.
        customer.setCustomerMoneyAvailable(customer.getCustomerMoneyAvailable() - totalCost);
        customer.setCustomerTicketsPurchased(customer.getCustomerTicketsPurchased() + quantity);
        customer.setTransactionCount(customer.getTransactionCount() + 1);
    }

    /**
     * Description: This method updates event data.
     * @param nodeData Holds event data.
     * @param numTickets Holds amount of tickets.
     * @param totalCost Holds total cost to include sales tax for Texas.
     * @param ticketOption Holds ticket type.
     */
    public void updateEvent(NodeData nodeData, int numTickets, double totalCost, String ticketType){
        //! Update event data.
        TicketAnalytics ticketAnalytics = nodeData.getTicketsData().getTicketAnalytics();
        ticketAnalytics.updateAnalytics(numTickets, totalCost,ticketType);
    }

    /**
     * Description: This method checks if the customer has enough money to purchase ticket(s).
     * @param customer Holds customer data.
     * @param totalCost Holds total cost to include sales tax for Texas.
     * @return valid amount of money
     */
    public boolean hasEnoughMoney(Customer customer, double totalCost){
        //! Check if enough money.
        return (customer.getCustomerMoneyAvailable() >= totalCost);
    }

    /**
     * Description: This method check if there is enough tickets available to make purchase.
     * @param ticketType Holds ticket type.
     * @param ticketQuantity Holds amount of tickets.
     * @param tickets Holds ticket data object.
     * @return The true if available else false.
     */
    public boolean hasEnoughSeats(String ticketType, int ticketQuantity, TicketAnalytics tickets) {
        //! Check if enough tickets.
        return tickets.ticketAvailability(ticketType, ticketQuantity);
    }
}
