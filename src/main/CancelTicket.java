package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 * @author ESDT LLC 
 * @since 15NOV2023
 * Description: This class helps to cancel a ticket and refund the customer their money
 */
public class CancelTicket {
    

    /**
     * Description: Default, Constructor.
     */
    public CancelTicket(){}


    /**
     * Description: This method cancels the ticket the customer wants to cancel.
     * @param customer Holds customer data.
     */
    public void cancelTicket(Customer customer){
        
        try {
            
            ArrayList<String> ticketsOwned = customer.getTicketsOwned();
    
            UserInputHandler userInputHandler = new UserInputHandler();

            ConversionOfDataTypes conversion = ConversionOfDataTypes.getInstance();
    
            while(true){
                //! Print tickets.
                customer.printTicketOwned();
                
                //! Prompt which one to cancel.
                System.out.println("Please enter the invoice receipt number of the ticket you want to cancel that is not already canceled. EX: INVOICE RECEIPT #1 ");
                System.out.println("Enter 0 if you do not want to cancel a ticket.");
                System.out.print(">> ");
    
                //! Store the option.
                int invoiceReceiptNumber = userInputHandler.isInRange(new Scanner(System.in), 0, ticketsOwned.size());
    
                //! If enters 0 then exit.
                if(invoiceReceiptNumber == 0){
                    System.out.println("you no longer want to cancel ticket(s).");
                    break;
                }
                //! Get the invoice
                String invoice = ticketsOwned.get(invoiceReceiptNumber - 1);
    
                //! Check if invoice canceled. If so print already canceled.Else cancel it.
                if(invoice.contains("CANCELED")){
                    System.out.println("Ticket is already canceled.");
                } else{
                    //! Get the line the ID is stored at.
                    String [] eventIDLine = invoice.split("\n")[3].split(":");
    
                    //! Check if is is of length two.
                    if(eventIDLine.length >= 2){
                        //! Get the event Id to cancel.
                        int eventID = conversion.convertToInteger((eventIDLine[1].trim()));

                        //! Get the confirmation number stored at.
                        String []confirmationNumber = invoice.split("\n")[8].split(":");
    
                        //! Check if length of two.
                        if(confirmationNumber.length >= 2){
                            //! Update event data and customer data.
                            reimbursements(customer, eventID, confirmationNumber[1].trim());
                            //! update the invoices.
                            updateCustomerInvoice(invoiceReceiptNumber-1, ticketsOwned, customer);
                            //! Update number of ticket(s) canceled.
                            customer.setTicketsCanceled(customer.getTicketsCanceled() + 1);
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }catch(ArrayIndexOutOfBoundsException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(InputMismatchException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }
    
    /**
     * Description: This method updates event data and customer data.
     * @param customer Holds customer data.
     * @param eventID Holds event data.
     * @param confirmationNumber Holds confirmation number.
     */
    public void reimbursements(Customer customer, int eventID, String confirmationNumber){

        try {
            //! Store the customer tickets owned.
            HashMap<Integer, ArrayList<Ticket>> customerTransactions = customer.getCustomerTransactions();
            //! Store the event ticket owned.
            HashMap<Integer, ArrayList<Ticket>> eventTransaction = Event.getTicketOwned();
            //! Store the customer tickets in array list.
            ArrayList<Ticket> customerTickets = customerTransactions.get(eventID);
            //! Store the event tickets in array list.
            ArrayList<Ticket> eventTickets = eventTransaction.get(eventID);
    
            //! Runs through customer tickets owned.
            for (Ticket ticket : customerTickets) {
                //! check if confirmation number matches. if so cancel ticket.
                if(ticket.getConfirmationNumber().equals(confirmationNumber)){
                    //! Update customer data.
                    customer.setCustomerMoneyAvailable(customer.getCustomerMoneyAvailable() + ticket.getSubTotal());
                    customer.setTotalSavings(customer.getTotalSavings() - ticket.getTotalSaved());
                    //! Store to variables.
                    double ticketCostWithoutTax = ticket.getTicketCost() * (1 - .0825);
                    String ticketType = ticket.getTicketType();

                    customer.setReimbursementAmount(customer.getReimbursementAmount() + ticket.getSubTotal());
    
                    //! Get the event of the canceled ticket .
                    NodeData node = ConfigureEventDetails.getEventDataMap().get(eventID);
                    //! Get the event invoices that were stored.
                    ArrayList<String> ticketsPurchasedArray = node.getEventData().getTicketsPurchasedArray();
                    
                    //! update the tickets invoices.
                    updateEventInvoice(ticketsPurchasedArray, confirmationNumber);
    
                    //! Store ticket analytics object.
                    TicketAnalytics ticketAnalytics = node.getTicketsData().getTicketAnalytics();
                    //! Update the ticket analytics data.
                    ticketAnalytics.updateAnalytics(ticket.getTicketNum(), ticketCostWithoutTax, ticketType);
                    
                    //! Remove the customer ticket that was canceled.
                    customerTickets.remove(ticket);
                    //! Remove the stored ticket from event.
                    eventTickets.remove(ticket);
                    break;
                }
            }
            
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(ArrayIndexOutOfBoundsException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: This method updates event Invoices. 
     * @param invoice Holds invoices.
     * @param confirmationNumber Holds confirmation number.
     */
    public void updateEventInvoice(ArrayList<String> invoice, String confirmationNumber){

        try {
            //! for accessing invoice array list.
            int i = 0;
            //! Run through invoices.
            for (String invoiceText : invoice) {
                //! Update the invoice to be canceled and set the invoice in the array list.
                if(invoiceText.contains(confirmationNumber) && !invoiceText.contains("CANCELED")){
                    invoice.set(i, invoiceText.replace(invoiceText.split("\n")[1], invoiceText.split("\n")[1] + " (Ticket CANCELED)"));
                }
                //! Update if still not found.
                i++;
            }       
        } catch (ArrayIndexOutOfBoundsException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: THis method updates customer invoices.
     * @param invoiceNumber Holds invoice number.
     * @param invoice Holds invoice data.
     */
    public void updateCustomerInvoice(int invoiceNumber, ArrayList<String> invoice, Customer customer){
        
        try {
            //! Store the invoice of canceled ticket.
            String invoiced = invoice.get(invoiceNumber);
    
            //! Update the invoice to be canceled and set it in the invoice array list.
            invoice.set(invoiceNumber, invoiced.replace(invoiced.split("\n")[1], invoiced.split("\n")[1] + " (Ticket CANCELED)"));


            PrintWriter invoiceTextFile = new PrintWriter(new FileOutputStream( "Invoices/" + customer.getLastName() + "_" + customer.getFirstName()+ "/Invoice.txt"));

            for (String text : invoice) {
                invoiceTextFile.println(text);
                invoiceTextFile.flush();
            }
            invoiceTextFile.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }  catch (FileNotFoundException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(NullPointerException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }
}