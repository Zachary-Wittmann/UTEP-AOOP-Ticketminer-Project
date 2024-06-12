package main;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description: This class is designed to store the data that was read in from an excel. It will call a factory class to get the correct child object of Event and Venue class.
 * The data will be stored as a node (event data, venue data, ticket data) in a linked list class. Some  methods refactored and collaborated together via live share.
 * @author ESDT LLC
 * @since 10/30/2023
 */
public class ConfigureEventDetails{
    

    //! Storing the excel file name of the event list.
    private String fileName;

    //! TempEvent will hold sport, convert, or festival object
    private Event tempEvent;

    //! tempTicket will hold TicketHandler object. From Raul and Fernando.
    private TicketsHandler tempTickets;

    //! factory is used to create the correct children objects. From Fernando.
    private VenueFactory venueFactory;
    private EventFactory eventFactory;

    //! Holds max ID.
    private static int maxID;

    //! HashMap for store event Data.
    private static HashMap<Integer, NodeData> eventDataMap = new HashMap<>();
    private static HashMap<String, Integer> eventNameMap = new HashMap<>();


    /**
     * Description: Default Constructor.
     */
    public ConfigureEventDetails(){}

    /**
     * Description: Constructor, Takes in file to be read and the factory to create the objects.From Raul and Fernando.
     * @param fileName Holds the filename to be read in
     * @param eventFactory Holds the event factory object
     * @param venueFactory Holds the venue factory object.
     */ 
    public ConfigureEventDetails(String fileName, EventFactory eventFactory, VenueFactory venueFactory){
        setFileName(fileName);
        setEventFactory(eventFactory);
        setVenueFactory(venueFactory);
    }

    /**
     * Description: Get the name of the file being read.From Raul and Fernando.
     * @return the file name String type
     */
    public String getFileName() {
        return this.fileName;
    }
    /**
     * Description: Set the name of the file that will be read.From Raul and Fernando.
     * @param fileName Sets the file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Description: Get the temp event object.From Raul.
     * @return The Event data
     */
    public Event getTempEvent() {
        return this.tempEvent;
    }

    /**
     * Description: Set the temp event type og object.From Raul.
     * @param tempEvent Sets event data
     */
    public void setTempEvent(Event tempEvent) {
        this.tempEvent = tempEvent;
    }


    /**
     * Description: Get the temp tickets object.From Raul and Fernando.
     * @return Ticket data
     */
    public TicketsHandler getTempTickets() {
        return this.tempTickets;
    }
    /**
     * Description: Set the temp tickets for event/venue.From Raul and Fernando.
     * @param tempTickets Set Ticket data
     */
    public void setTempTickets(TicketsHandler tempTickets) {
        this.tempTickets = tempTickets;
    }

    /**
     * Description: Get the Venue factory object. From Fernando.
     * From fernando
     * @return The venue factory object
     */
    public VenueFactory getVenueFactory() {
        return this.venueFactory;
    }
    /**
     * Description: Se the venue factory object. From Fernando.
     * From fernando
     * @param venueFactory Holds the venue factory object
     */
    public void setVenueFactory(VenueFactory venueFactory) {
        this.venueFactory = venueFactory;
    }

    /**
     * Description: Get the event factory object. From Fernando.
     * From fernando
     * @return The event factory object.
     */
    public EventFactory getEventFactory() {
        return this.eventFactory;
    }

    /**
     * Description: Set teh event factory object. From Fernando.
     * From fernando
     * @param eventFactory Holds the event factory object.
     */
    public void setEventFactory(EventFactory eventFactory) {
        this.eventFactory = eventFactory;
    }

    /**
     * Description: Get the max ID.
     * @return The max ID.
     */
    public static int getMaxID() {
        return maxID;
    }
    /**
     * Description: Set the max ID.
     * @param maxID Holds max ID.
     */
    public static void setMaxID(int maxID) {
        ConfigureEventDetails.maxID = maxID;
    }

    /**
     * Description: Get the event Map.
     * @return The Event hashMap.
     */
    public static HashMap<Integer, NodeData> getEventDataMap() {
        return eventDataMap;
    }

    /**
     * Description: Set the event data Map.
     * @param eventDataMap Holds the event data hashMap.
     */
    public static void setEventDataMap(HashMap<Integer, NodeData> eventDataMap) {
        ConfigureEventDetails.eventDataMap = eventDataMap;
    }

    /**
     * Description: Get the event name Map.
     * @return The event name hashMap.
     */
    public static HashMap<String, Integer> getEventNameMap() {
        return eventNameMap;
    }

    /**
     * Description: Set the event name Map.
     * @param eventNameMap Holds the event name hashMap.
     */
    public static void setEventNameMap(HashMap<String, Integer> eventNameMap) {
        ConfigureEventDetails.eventNameMap = eventNameMap;
    }


    /**
     * Description: This method stores the data from the read in file and stores them to the correct attributes. From Raul.
     */
    public void setFileDataToAttributes(){

        try{
            //! Create a hashmap of key-> strings, value -> string
            HashMap<String, String> hashMapFileData = new HashMap<>();

            //! Create reference.
            CSVReader csvReader = CSVReader.getInstance();

            //! Create reference
            FileDataStorage fileDataStorage = FileDataStorage.getInstance();

            //! Store the event data line by line.
            ArrayList<String[]> fileData = fileDataStorage.getEventFileData();

            //! Call to store data.
            fileData = csvReader.readCSV(getFileName());

            //! Store file data.
            fileDataStorage.setEventFileData(fileData);

            //! This is where the header line from the file read is located at.
            String [] headerLine = fileData.get(0);

            //! Create reference.
            HeadersLocations eventHeaderReference = HeadersLocations.getInstance();

            //! Get the location of the header cells.
            HashMap<String, Integer> eventCellLocations = eventHeaderReference.getHeaderLocationEvent();

            //! Store the header with the associated columns number of its position in the excel file.
            for (int i = 0; i < headerLine.length; i++) {
                eventCellLocations.put(headerLine[i].toLowerCase(), i);
            }

            for (int i = 1; i < fileData.size(); i++) {
                String [] rowData = fileData.get(i);

                //! Get the event, Call the factory Event method to create correct child object of parent Event class.
                setTempEvent(getEventFactory().createEvent(rowData[ eventCellLocations.get("event type")]));

                //! Get Venue, Call the factory Venue method to create correct child objects of the parent Venue class.

                getTempEvent().setVenue(getVenueFactory().createVenue(rowData[ eventCellLocations.get("venue type")]));

                //! Set finances
                getTempEvent().setFinances(new Finances());

                //! Get tickets, create new TicketHandler.
                setTempTickets(new TicketsHandler());
                
                //! Store the header name with their data.
                for (int j = 0; j < rowData.length; j++) {
                    String headerName = headerLine[j].toLowerCase();
                    String value =rowData[j];

                    hashMapFileData.put(headerName, value);
                }

                //! Set the attributes.
                _setFileDataToAttributesHelper(hashMapFileData);

                //! Store data in the hashmap one for holds object and other for holds string name with ID pair.
                getEventDataMap().put(getTempEvent().getEventID(), new NodeData(getTempEvent(), getTempTickets()));
                getEventNameMap().put(getTempEvent().getEventName().toLowerCase(), getTempEvent().getEventID());
            }   
        } catch(ArrayIndexOutOfBoundsException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }catch(NullPointerException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }

    }

    /**
     * Description: This method is a helper method that helps set the data to the correct attributes.From Raul.
     * @param fileData Holds the mapping of the header with the cell values.
     */
    public void _setFileDataToAttributesHelper(HashMap<String, String> fileData){

            try {
                //! TO help convert the string data from excel file to correct data type for hte attributes.
                ConversionOfDataTypes conversion = ConversionOfDataTypes.getInstance(); 

                //! Run through the hasMap data. Key-> the header names, values is the cell that is associated to that header.
                for (String key : fileData.keySet()) {
                    //! Stores the data correctly using key.
                    switch(key){
                        case "event id":
                            getTempEvent().setEventID(conversion.convertToInteger(fileData.get(key)));
                            break;
                        case "event type":
                            getTempEvent().setEventType(conversion.convertToString(fileData.get(key)).toLowerCase());
                            break;
                        case "name":
                            getTempEvent().setEventName(conversion.convertToString(fileData.get(key)));
                            break;
                        case "date":
                            getTempEvent().setDate(conversion.convertToString(fileData.get(key)));
                            break;
                        case "time":
                            getTempEvent().setTime(conversion.convertToString(fileData.get(key)));
                            break;
                        case "vip price":
                            getTempTickets().setVipPrice(conversion.convertToDouble(fileData.get(key)));
                            break;
                        case "gold price":
                            getTempTickets().setGoldPrice(conversion.convertToDouble(fileData.get(key)));
                            break;
                        case "silver price":
                            getTempTickets().setSilverPrice(conversion.convertToDouble(fileData.get(key)));
                            break;
                        case "bronze price":
                            getTempTickets().setBronzePrice(conversion.convertToDouble(fileData.get(key)));
                            break;
                        case "general admission price":
                            getTempTickets().setGeneralAdmissionPrice(conversion.convertToDouble(fileData.get(key)));
                            break;
                        case "venue name":
                            getTempEvent().getVenue().setVenueName(conversion.convertToString(fileData.get(key)));
                            break;
                        case "pct seats unavailable":
                            getTempEvent().getVenue().setPctSeatsUnavailable(conversion.convertToInteger(fileData.get(key)));
                            break;
                        case "venue type":
                            getTempEvent().getVenue().setVenueType(conversion.convertToString(fileData.get(key)));
                            break;
                        case "capacity":
                            getTempEvent().getVenue().setVenueCapacity(conversion.convertToInteger(fileData.get(key)));
                            break;
                        case "cost":
                            getTempEvent().getVenue().setVenueCost(conversion.convertToDouble(fileData.get(key)));
                            break;
                        case "vip pct":
                            getTempEvent().getVenue().setVipPct(conversion.convertToInteger(fileData.get(key)));
                            break;
                        case "gold pct":
                            getTempEvent().getVenue().setGoldPct(conversion.convertToInteger(fileData.get(key)));
                            break;
                        case "silver pct":
                            getTempEvent().getVenue().setSilverPct(conversion.convertToInteger(fileData.get(key)));
                            break;
                        case "bronze pct":
                            getTempEvent().getVenue().setBronzePct(conversion.convertToInteger(fileData.get(key)));
                            break;
                        case "general admission pct":
                            getTempEvent().getVenue().setGeneralPct(conversion.convertToInteger(fileData.get(key)));
                            break;
                        case "reserved extra pct":
                            getTempEvent().getVenue().setReservedExtraPct(conversion.convertToInteger(fileData.get(key)));
                            break;
                        case "fireworks planned":
                            getTempEvent().getVenue().setFireworksPlanned(conversion.convertStringToBoolean(fileData.get(key)));
                            break;
                        case "fireworks cost":
                            getTempEvent().getVenue().setFireworksCost(conversion.convertToDouble(fileData.get(key)));
                            break;
                        default:
                            break;
                    }
                }
                
                //! Keep track of max ID for event and keep updating the max ID.
                if(getMaxID() < getTempEvent().getEventID()){
                    setMaxID(getTempEvent().getEventID());
                }

                //! Set the array list of ticket names, prices.
                getTempTickets().setTicketNames();
                getTempTickets().setTicketPrices(); 
                //! Create analytics per event. The tickets availability, sold, revenue, profits.
                getTempTickets().setTicketsAnalytics( TicketAnalyticsMaker.createAnalytics(getTempEvent().getVenue(), getTempTickets()));
                
            } catch(NullPointerException e){
                //! Log the exception that happened.
                ExceptionLogger.logExceptionsThrown(e);
            }
        }
}

