package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 * @author ESDT LLC 
 * @since 15NOV2023
 * Description: This class helps to cancel an event and refund the ticket goers their money
 */
public class CancelEvent {

    /**
     * Description: Default, Constructor.
     */
    public CancelEvent(){}


    /**
     * Description: This method cancels the event and give customer the money back.
     * @param node Holds event to cancel
     */
    public void reimbursements(NodeData node) {


        try {
            //! Get the tickets hashMap for event and get the array at event ID.
            HashMap<Integer, ArrayList<Ticket>> hashMapTickets = Event.getTicketOwned();
            ArrayList<Ticket> tickets =  hashMapTickets.get(node.getEventData().getEventID());

            Finances finances = node.getEventData().getFinances();
            //! Create new Ticket analytics object.

            if(tickets == null){
                node.getEventData().setIsCanceled(true);

                System.out.println("Event was canceled");
                //! Remove the any key-> event ID from the hashMap for event hold tickets.
                hashMapTickets.remove(node.getEventData().getEventID()); return;
            }
    
            //! Run through every ticket bought for the event ID and refund the customers money.
            for (Ticket ticket : tickets) {
                //! Get customer.
                Customer customer = Customer.getCustomerMap().get(ticket.getCustomerID());
                //! give all their money back
                customer.setCustomerMoneyAvailable(customer.getCustomerMoneyAvailable() + ticket.getTicketCost());
                //! updated money saved.
                customer.setTotalSavings(customer.getTotalSavings() - ticket.getTotalSaved());
                //! Update tax and discount for event.
                finances.setTotalDiscounted(finances.getTotalDiscounted() - ticket.getTotalSaved());
                double tax = (ticket.getTicketCost() * .0825)/ (1+.0825);
                finances.setTotalTax(finances.getTotalTax() - tax);

                //! Update fees.
                finances.setTotalCharityFee(finances.getTotalCharityFee() - ticket.getCharityFee());
                finances.setTotalServiceFee(finances.getTotalServiceFee() - ticket.getServiceFee());
                finances.setTotalConvenienceFee(finances.getTotalConvenienceFee() - ticket.getConvenienceFee());
                finances.setTotalFees(finances.getTotalFees() - ticket.getCharityFee() - ticket.getConvenienceFee() - ticket.getServiceFee());

                //! Update fees for all event attributes.
                finances.setTotalCharityFeeForAllEvents(finances.getTotalCharityFeeForAllEvents() - ticket.getCharityFee());
                finances.setTotalConvenienceFeeForAllEvents(finances.getTotalConvenienceFeeForAllEvents() - ticket.getConvenienceFee());
                finances.setTotalServiceFeeForAllEvents(finances.getTotalServiceFeeForAllEvents() - ticket.getServiceFee());
                finances.setTotalFeesForAllEvent(finances.getTotalFeesForAllEvent() - ticket.getCharityFee() - ticket.getConvenienceFee() - ticket.getServiceFee());

                //!Update profit and revenue.
                customer.setReimbursementAmount(customer.getReimbursementAmount() + ticket.getTicketCost());

                //! Get event type and ticket confirmation number.
                String eventType = node.getEventData().getEventType();
                String confirmationNumber = ticket.getConfirmationNumber();

                //! Update the invoice to be canceled.
                updateInvoice(customer, eventType, confirmationNumber);
                
                //! Remove the ticket from customer since it was canceled.
                customer.getCustomerTransactions().get(node.getEventData().getEventID()).remove(ticket);
            }
            //! Reset tickets analytics since event was canceled.
            TicketAnalytics ticketAnalytics = TicketAnalyticsMaker.createAnalytics(node.getEventData().getVenue(), node.getTicketsData());
            //! Store the reset analytics.
            node.getTicketsData().setTicketsAnalytics(ticketAnalytics);

            //! Set event status to canceled.
            node.getEventData().setIsCanceled(true);

            System.out.println("Event was canceled");
            //! Remove the any key-> event ID from the hashMap for event hold tickets.
            hashMapTickets.remove(node.getEventData().getEventID());
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: This method updates the invoices.
     * @param customer Holds customer data.
     * @param eventName Holds the event name to cancel.
     * @param confirmationNumber Holds the confirmation number.
     */
    public void updateInvoice(Customer customer, String eventName, String confirmationNumber){

        try {
            
            //! Get customers invoices.
            ArrayList<String> invoice = customer.getTicketsOwned();
    
            //! For array of invoices.
            int i = 0;
            //! Run through invoiced.
            for (String invoiceText : invoice) {
                //! Check if the event name and confirmation number in invoiced match, if so updated it to have the word canceled in it.
                if(invoiceText.contains(eventName) && invoiceText.contains(confirmationNumber) && !invoiceText.contains("CANCELED")) {
                    invoice.set(i, invoiceText.replace(invoiceText.split("\n")[1], invoiceText.split("\n")[1] + " (Event CANCELED)"));
                }
                //! increment index.
                i++;
            }


            PrintWriter invoiceTextFile = new PrintWriter(new FileOutputStream( "Invoices/" + customer.getLastName() + "_" + customer.getFirstName()+ "/Invoice.txt"));

            for (String text : invoice) {
                invoiceTextFile.println(text);
                invoiceTextFile.flush();
            }
            invoiceTextFile.close();
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(ArrayIndexOutOfBoundsException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch (FileNotFoundException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }





}