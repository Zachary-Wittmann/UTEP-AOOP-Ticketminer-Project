package main;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description: This class is meant to update the modified content(s) of the event list and customer list excel files and write updated contents to a new excel file.
 * @author Raul Pallares
 * @since 9/29/2023
 */
public class CSVUpdateHandler {
    


    /**
     * Description: Default Constructor.
     */
    public CSVUpdateHandler(){}

    /**
     * Description: This method adds new headers to the event header hashmap.
     */
    public void addEventHeaderColumns(){
        try {
            //! Create reference.
            HeadersLocations headersLocations = HeadersLocations.getInstance();

            //! Get the header data information for event list file.
            HashMap<String, Integer> eventHeader = headersLocations.getHeaderLocationEvent();

            //! Get the size of the hashmap.
            int eventHeaderSize = eventHeader.size();

            //! Store new headers to add.
            String[] newHeaders = {"vip seats sold", "gold seats sold", "silver seats sold","bronze seats sold",
                                    "general admission seats sold","total vip revenue" , "total gold revenue", 
                                    "total silver revenue", "total bronze revenue", "total general admission revenue", "money discounted","tax collected","charity fee", "service fee", "convenience fee", "is canceled"};

            //! Add new header to the header hashmap with respective cell locations.
            for (int i = 0; i < newHeaders.length; i++) {
                eventHeader.put(newHeaders[i], eventHeaderSize + i);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(NullPointerException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        

    }

    /**
     * Description: This method updates the data from event excel file.
     */
    public void updateEventData(){

        try {
            //! Create reference to FileDataStorage.
            FileDataStorage fileDataStorage = FileDataStorage.getInstance();
            //! Create reference to HeadersLocations
            HeadersLocations headersLocations = HeadersLocations.getInstance();
            //! Get the event data.
            ArrayList<String[]> eventFIleData = fileDataStorage.getEventFileData();
            //! Get the event header locations.
            HashMap<String, Integer> eventHeaderHashMap = headersLocations.getHeaderLocationEvent();
            //! Get the hashmap for event.
            HashMap<Integer, NodeData> eventDataMap = ConfigureEventDetails.getEventDataMap();

            

            //! Store the size of the header columns.
            int size = eventHeaderHashMap.size();
            //! Create new 1D string array length of header size.
            String[] tempRowText = new String[size];

            //! Store hashmap in order in a temp string 1D array.
            for (String key : eventHeaderHashMap.keySet()) {
                tempRowText[eventHeaderHashMap.get(key)] = key;
            }

            //! Assuming first line in excel file is the header.Set updated header.
            eventFIleData.set(0, tempRowText);

            //! Get the position the event id is at in the event excel file.
            int eventID = eventHeaderHashMap.get("event id");


            //! Run though the event data.
            for (int arrayListIndex = 1; arrayListIndex < eventFIleData.size(); arrayListIndex++) {
                //! Create new 1D string array of length size (header columns size).
                String[] newTextRow = new String[size]; 
                //! Run through the elements of each index of event data.
                for (int elementIndex = 0; elementIndex < eventFIleData.get(arrayListIndex).length; elementIndex++) {
                    //! Store the original data from eventFileData row to newTextRow.
                    newTextRow[elementIndex] = eventFIleData.get(arrayListIndex)[elementIndex];
                }

                //! Update the  modified data. Pass the event of the event ID, cell positions and new text data for event.
                _updateEventData(eventDataMap.get(Integer.valueOf(newTextRow[eventID])) , eventHeaderHashMap, newTextRow);
                //! Update the index data in event data to new textRow (holds modified data).
                eventFIleData.set(arrayListIndex, newTextRow); 
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);

        } catch(NullPointerException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }   

    }

    /**
     * Description: This method is a helper method to updateEventData. It Updates all the values that could have been modified for an event during the program and stores it in a 1D string array.
     * @param linkedList Holds the linked list data structure tha holds (eventData, VenueData, TicketData).
     * @param eventHashMap Holds the column header positions for event.
     * @param tempRowText Holds the row of text event data to modify.
     * @param target Holds the event ID number of get the correct data.
     * @param tax Holds the tax total amount
     */
    public void _updateEventData(NodeData nodeData, HashMap<String, Integer> eventHashMap, String[] tempRowText){

        try {
            //! Holds the eventData, venueData, and ticketData from that node.
            Event eventData = nodeData.getEventData();
            Venue venueData = nodeData.getEventData().getVenue();
            TicketsHandler ticketsData = nodeData.getTicketsData();
            TicketAnalytics profitAndRevenue = nodeData.getTicketsData().getTicketAnalytics();

            //! Create reference.
            ConversionOfDataTypes conversion = ConversionOfDataTypes.getInstance();
            
            //! Run through the whole hashmap data key, value pairs. Set the correct data associated with the header in correct index.
            for (String key : eventHashMap.keySet()) {  
                switch(key){
                    case "name":
                        tempRowText[eventHashMap.get(key)] = eventData.getEventName();
                        break;
                    case "date":
                        tempRowText[eventHashMap.get(key)] = eventData.getDate();
                        break;
                    case "time":
                        tempRowText[eventHashMap.get(key)] = eventData.getTime();
                        break;
                    case "vip price":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(ticketsData.getVipPrice());
                        break;
                    case "gold price":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(ticketsData.getGoldPrice());
                        break;
                    case "silver price":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(ticketsData.getSilverPrice());
                        break;
                    case "bronze price":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(ticketsData.getBronzePrice());
                        break;
                    case "general admission price":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(ticketsData.getGeneralAdmissionPrice());
                        break;
                    case "venue name":
                        tempRowText[eventHashMap.get(key)] = venueData.getVenueName();
                        break;
                    case "fireworks planned":
                        tempRowText[eventHashMap.get(key)] = conversion.convertBooleanToString(venueData.getFireworksPlanned());
                        break;
                    case "fireworks cost": 
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(venueData.getFireworksCost());
                        break;
                    case "vip seats sold":
                        tempRowText[eventHashMap.get(key)] = conversion.convertIntegerToString(profitAndRevenue.getTotalVipSeatsSold());
                        break;
                    case "gold seats sold":
                        tempRowText[eventHashMap.get(key)] = conversion.convertIntegerToString(profitAndRevenue.getTotalGoldSeatsSold());
                        break;
                    case "silver seats sold":
                        tempRowText[eventHashMap.get(key)] = conversion.convertIntegerToString(profitAndRevenue.getTotalSilverSeatsSold());
                        break;
                    case "bronze seats sold":
                        tempRowText[eventHashMap.get(key)] = conversion.convertIntegerToString(profitAndRevenue.getTotalBronzeSeatsSold());
                        break;
                    case "general admission seats sold":
                        tempRowText[eventHashMap.get(key)] = conversion.convertIntegerToString(profitAndRevenue.getTotalGeneralSeatsSold());
                        break;
                    case "total vip revenue": 
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(profitAndRevenue.getTotalVipTicketsRevenue());
                        break;
                    case "total gold revenue":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(profitAndRevenue.getTotalGoldTicketsRevenue());
                        break;
                    case "total silver revenue":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(profitAndRevenue.getTotalSilverTicketsRevenue());
                        break;
                    case "total bronze revenue":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(profitAndRevenue.getTotalBronzeTicketsRevenue());
                        break;
                    case "total general admission revenue":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(profitAndRevenue.getTotalGeneralTicketsRevenue());
                        break;
                    case "money discounted":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(eventData.getFinances().getTotalDiscounted());
                        break;
                    case "tax collected":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(eventData.getFinances().getTotalTax());
                        break;
                    case "charity fee":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(eventData.getFinances().getTotalCharityFee());
                        break;
                    case "service fee":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(eventData.getFinances().getTotalServiceFee());
                        break;
                    case "convenience fee":
                        tempRowText[eventHashMap.get(key)] = conversion.convertDoubleToString(eventData.getFinances().getTotalConvenienceFee());
                        break;
                    case "is canceled":
                        tempRowText[eventHashMap.get(key)] = conversion.convertBooleanToString(eventData.getIsCanceled());
                        break;
                    default:
                        break;
                }
            }
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(ArrayIndexOutOfBoundsException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: This method add new headers to the customer header hashmap.
     */
    public void addCustomerHeaderColumns(){

        try {
            //! Create reference.
            HeadersLocations headersLocations = HeadersLocations.getInstance();

            //! Get the header data information for customer list file.
            HashMap<String, Integer> customerHeader = headersLocations.getHeaderLocationCustomer();

            //! Get the size of the hashmap.
            int customerHeaderSize = customerHeader.size();

            //! Store new headers to add.
            String[] newHeader = {"transaction count", "money saved", "reimbursed", "tickets canceled"};

        //! Add the new header to the header hashmap with respective cell locations.
        for (int i = 0; i < newHeader.length; i++) {
            customerHeader.put(newHeader[i], customerHeaderSize + i);
        }

        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(ArrayIndexOutOfBoundsException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }


    /**
     * Description: This method updates the modified data from customer excel file.
     */
    public void updateCustomerData(){

        try {
            //! Create reference to FileDataStorage.
            FileDataStorage fileDataStorage = FileDataStorage.getInstance();
            //! Create reference to HeadersLocations
            HeadersLocations headersLocations = HeadersLocations.getInstance();
            //! Get the customer data.
            ArrayList<String[]> customerFileData = fileDataStorage.getCustomerFileData();
            //! Get the customer header locations.
            HashMap<String, Integer> customerHeaderHashMap = headersLocations.getHeaderLocationCustomer();

            //! Get the customer data.
            HashMap<Integer, Customer> customerDataMap = Customer.getCustomerMap(); 

            //! Store the size of the header columns.
            int size = customerHeaderHashMap.size();
            //! Create new 1D string array length of header size.
            String[] tempRowText = new String[size];

            //! Store hashmap in order in a temp string 1D array.
            for (String key : customerHeaderHashMap.keySet()) {
                tempRowText[customerHeaderHashMap.get(key)] = key;
            }

            //! Assuming first line in excel file is the header.Set updated header.
            customerFileData.set(0, tempRowText);

            //! Get the position the person id is located at in excel file.
            int personId =  customerHeaderHashMap.get("id"); 

            //! Run though the event data.
            for (int arrayListIndex = 1; arrayListIndex < customerFileData.size() ; arrayListIndex++) {
                //! Create new 1D string array of length size (header columns size).
                String[] newTextRow = new String[size]; 
                //! Run through the elements of each index of customer data.
                for (int elementIndex = 0; elementIndex < customerFileData.get(arrayListIndex).length; elementIndex++) {
                    //! Store the original data from customerFileData row to newTextRow.
                    newTextRow[elementIndex] = customerFileData.get(arrayListIndex)[elementIndex];

                }
                //! Update the modified data. Pass the customer of the person id, cell locations, customer data.
                _updateCustomerData(customerDataMap.get(Integer.valueOf(newTextRow[personId])), customerHeaderHashMap, newTextRow);
                //! Update the index data in customer data to new textRow (holds modified data).
                customerFileData.set(arrayListIndex , newTextRow); 
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(NullPointerException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }

    }


    /**
     * Description: This method is a helper method to updateCustomerData. It updates all the values tha could have been modified for a customer during the program and stores it in 1D array.
     * @param customers Holds the array list of customer data.
     * @param customerHashMap Holds teh column header positions for customer.
     * @param tempRowText Holds the row of tet customer data to modify.
     * @param target Holds the target index to get teh customer data. 
     */
    public void _updateCustomerData( Customer currentCustomer, HashMap<String, Integer> customerHashMap, String[] tempRowText ){
        try {

            //! Create reference.
            ConversionOfDataTypes conversion = ConversionOfDataTypes.getInstance();

            //! Run through the whole hashmap data key, value pairs. Set the correct data associated with the header in correct index.
            for (String key : customerHashMap.keySet()){
                switch(key){
                    case "transaction count":
                        tempRowText[customerHashMap.get(key)] = conversion.convertIntegerToString(currentCustomer.getTransactionCount());
                        break;
                    case "money available":
                        tempRowText[customerHashMap.get(key)] = conversion.convertDoubleToString(currentCustomer.getCustomerMoneyAvailable());
                        break;
                    case "tickets purchased":
                        tempRowText[customerHashMap.get(key)] = conversion.convertIntegerToString(currentCustomer.getCustomerTicketsPurchased());
                        break;
                    case "money saved":
                        tempRowText[customerHashMap.get(key)] = conversion.convertDoubleToString(currentCustomer.getTotalSavings());
                        break;
                    case "reimbursed":
                        tempRowText[customerHashMap.get(key)] = conversion.convertDoubleToString(currentCustomer.getReimbursementAmount());
                        break;
                    case "tickets canceled":
                        tempRowText[customerHashMap.get(key)] = conversion.convertIntegerToString(currentCustomer.getTicketsCanceled());
                        break;
                    default:
                        break;
                }
            } 
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(ArrayIndexOutOfBoundsException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: This method every method needed to updated the event data and write to an excel file.
     * @param linkedList Holds the linked list data structure for event.
     * @param filename Holds new excel file to write to.
     */
    public void createUpdatedEventFile(String filename){

        try {
            //! create reference to write to an excel file.
            CSVFileWriter csvFileWriter = CSVFileWriter.getInstance();
            //! Create reference to get the stored data.
            FileDataStorage fileDataStorage = FileDataStorage.getInstance();

            //! Create new headers for event.
            addEventHeaderColumns();
            //! Update the event.
            updateEventData();

            //! Write updated contents to a new excel file.
            csvFileWriter.writeFile(fileDataStorage.getEventFileData(), filename);
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }


    /**
     * Description: This method every method needed to updated the customer data and write to an excel file.
     * @param customers Holds the array list of customers.
     * @param filename Holds new excel file to write to.
     */
    public void createUpdatedCustomerFile(String filename){

        try {
            //! create reference to write to an excel file.
            CSVFileWriter csvFileWriter = CSVFileWriter.getInstance();
            //! Create reference to get the stored data.
            FileDataStorage fileDataStorage = FileDataStorage.getInstance();

            //! Create new headers for customers.
            addCustomerHeaderColumns();
            //! Update the customers.
            updateCustomerData();


            //! Write updated contents to a new excel file
            csvFileWriter.writeFile(fileDataStorage.getCustomerFileData(), filename);
        } catch (ArrayIndexOutOfBoundsException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }
}