package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Description: This class is used to create an invoice for the customer
 * @author Extreme Software Development Team LLC
 */
public class Invoice {

    //! Holds current data data.
    private Date date;

    /**
     * Formats values into a monetary way
     */
    public static DecimalFormat df = new DecimalFormat("$0.00");


    /**
     * Description: Default, Constructor.
     */
    public Invoice(){}


    /**
     * Description: Get the current data. From Fernando.
     * @return The data.
     */
    public Date getDate() {
        return this.date;
    }
    /**
     * Description: Set the current data.  From Fernando.
     * @param date Holds date data.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Description: get the current real time date. Fdate: Daterom Fernando.
     * @return current Date
     */
    public String computeCurrentDate(){
        //! Date formate.
        setDate(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("MMM. dd, yyyy"); 
        return (sdf.format(getDate()));
    }


    /**
     * Used to create an invoice for the customer and then send it to an Invoices
     * folder with subfolders for each customer
     * 
     * @param customer Holds the current customer
     * @param customersInvoiced Holds the invoice of the customer current transaction
     */
    public void customerInvoiceCreator(Customer customer, String customersInvoiced) {
        //! open Invoice folder in workspace.
        File invoices = new File("Invoices");
        //! Make/ open directory.
        invoices.mkdir();
        //! Create the customer file.
        File customerFile = new File("Invoices/" + customer.getLastName() + "_" + customer.getFirstName());
        //! Make/ open folder.
        customerFile.mkdir();

        try {
            //! Increment # invoices -> meaning customer made one transaction.
            customer.setInvoices(customer.getInvoices() + 1);
            
            //! Create a .txt for customer.
            PrintWriter invoice = new PrintWriter(new FileOutputStream( "Invoices/" + customer.getLastName() + "_" + customer.getFirstName()+ "/Invoice.txt", true));

            invoice.println(customersInvoiced);
            invoice.close();

        } catch (FileNotFoundException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(NullPointerException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }


    /**
      * Description: write a invoice that will be used to a txt file. From Fernando.
      * @param customer Holds customer data.
      * @param nodeData holds event data.
      * @param totalCost holds price of customer.
      * @param ticketType Holds ticket type for customer.
      * @param ticketQuantity Holds ticket amount.
      * @return the invoice for the customer.
      */
    public String getInfo(Customer customer, NodeData nodeData, double totalCost, String ticketType, int ticketQuantity){
        String info = "";
        try {
            //! Get event data.
            Event tmpEvent = nodeData.getEventData();
            //! Get singleton object to do confirmation number for a customer.
            CustomerConfirmation customerConfirmation = CustomerConfirmation.getInstance();
            
            //! Store invoice data in string and return the message.
            info = "-------------------------------------------\n";
            info += "| INVOICE RECEIPT #" + (customer.getInvoices()+1)+ " |\n";
            info += "Customer: " + customer.getFirstName() + " " + customer.getLastName() +"\n";
            info += "Event ID: " + tmpEvent.getEventID() + "\n";
            info += "-------------------------------------------\n";
            info += "This confirms your recent payment of " + ticketQuantity + " ticket(s) at "+ ticketType + " totaling " + df.format(totalCost) + " on " + computeCurrentDate() +"\n";
            info +="| ---- DATE ---- |  ----------- DESCRIPTION ----------- | --- AMOUNT PAID --- |\n";
            info += "| --- " + tmpEvent.getDate() + " --- | " + tmpEvent.getEventName() + " ( " + tmpEvent.getEventType() +" Event ) at " + tmpEvent.getTime() + " | --- " + df.format(totalCost) + " --- |\n";
            info += "Confirmation Number: " + customerConfirmation.hashCode(customer, nodeData, ticketType) +  (customer.getCustomerMembership() ? "IM" : "NM") + 
                    customer.getCustomerTicketsPurchased() + "\n";
            return info;
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return info;

    }
    
}
