package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Description: This class is used to add events to the linked list.
 * @author Extreme Software Development Team LLC
 */
public class EventAdder {
    
    //! TempEvent will hold sport, convert, or festival object
    private Event tempEvent;


    //! tempTicket will hold TicketHandler object.
    private TicketsHandler tempTickets;

    //! factory is used to create the correct children objects. From Fernando.
    private VenueFactory venueFactory;
    private EventFactory eventFactory;


    /**
     * Description: Default, Constructor.
     */
    public EventAdder(){}


    /**
     * Description: Constructor, pass event, venue factory and ticketHandler.
     * @param eventFactory Holds event factory object.
     * @param venueFactory Holds venue factory object.
     * @param ticketsHandler Holds ticket object.
     */
    public EventAdder(EventFactory eventFactory, VenueFactory venueFactory, TicketsHandler ticketsHandler){
        setEventFactory(eventFactory);
        setVenueFactory(venueFactory);
        setTempTickets(ticketsHandler);
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
     * Description: This method stores the node data from new event created into an array at append to the stored event data in the array list of events.
     * @param node Holds event, venue, ticketsHandler object data.
     */
    public void addToEventArray(NodeData node){
        

        try {
            //! Create instances. 
            FileDataStorage fileDataStorage = FileDataStorage.getInstance();
            //! Create instances. 
            HeadersLocations headersLocations = HeadersLocations.getInstance();
            //! Get event data. 
            ArrayList<String[]> eventData = fileDataStorage.getEventFileData();
            //! get headers locations in excel file. 
            HashMap<String, Integer> headersMap = headersLocations.getHeaderLocationEvent();
            //! Create instances. 
            ConversionOfDataTypes conversion = ConversionOfDataTypes.getInstance();

            //! Easier to access.
            Event event = node.getEventData();
            Venue venue = node.getEventData().getVenue();
            TicketsHandler ticketsHandler = node.getTicketsData();

            //! Headers locations.
            String [] headers = eventData.get(0);

            //! Used to store added event.
            String [] data = new String[headers.length];

            //! Store the node data containing the event into an array.
            for (String key : headersMap.keySet()) {
                //! Stores the data correctly using key.
                switch(key){
                    case "event id":
                        data[headersMap.get(key)] = conversion.convertIntegerToString(event.getEventID());
                        break;
                    case "event type":
                        data[headersMap.get(key)] = conversion.convertToString(event.getEventType());
                        break;
                    case "name":
                        data[headersMap.get(key)] = conversion.convertToString(event.getEventName());
                        break;
                    case "date":
                        data[headersMap.get(key)] = conversion.convertToString(event.getDate());
                        break;
                    case "time":
                        data[headersMap.get(key)] = conversion.convertToString(event.getTime());
                        break;
                    case "vip price":
                        data[headersMap.get(key)] = conversion.convertDoubleToString(ticketsHandler.getVipPrice());
                        break;
                    case "gold price":
                        data[headersMap.get(key)] =  conversion.convertDoubleToString(ticketsHandler.getGoldPrice());
                        break;
                    case "silver price":
                        data[headersMap.get(key)] =  conversion.convertDoubleToString(ticketsHandler.getSilverPrice());
                        break;
                    case "bronze price":
                        data[headersMap.get(key)] =  conversion.convertDoubleToString(ticketsHandler.getBronzePrice());
                        break;
                    case "general admission price":
                        data[headersMap.get(key)] =  conversion.convertDoubleToString(ticketsHandler.getGeneralAdmissionPrice());
                        break;
                    case "venue name":
                        data[headersMap.get(key)] = conversion.convertToString(venue.getVenueName());
                        break;
                    case "pct seats unavailable":
                        data[headersMap.get(key)] = conversion.convertIntegerToString(venue.getPctSeatsUnavailable());
                        break;
                    case "venue type":
                        data[headersMap.get(key)] = conversion.convertToString(venue.getVenueType());
                        break;
                    case "capacity":
                        data[headersMap.get(key)] = conversion.convertIntegerToString(venue.getVenueCapacity());
                        break;
                    case "cost":
                        data[headersMap.get(key)] = conversion.convertDoubleToString(venue.getVenueCost());
                        break;
                    case "vip pct":
                        data[headersMap.get(key)] = conversion.convertIntegerToString(venue.getVipPct());
                        break;
                    case "gold pct":
                        data[headersMap.get(key)] = conversion.convertIntegerToString(venue.getGoldPct());
                        break;
                    case "silver pct":
                        data[headersMap.get(key)] = conversion.convertIntegerToString(venue.getSilverPct());
                        break;
                    case "bronze pct":
                        data[headersMap.get(key)] = conversion.convertIntegerToString(venue.getBronzePct());
                        break;
                    case "general admission pct":
                        data[headersMap.get(key)] = conversion.convertIntegerToString(venue.getGeneralPct());
                        break;
                    case "reserved extra pct":
                        data[headersMap.get(key)] = conversion.convertIntegerToString(venue.getReservedExtraPct());
                        break;
                    case "fireworks planned":
                        data[headersMap.get(key)] = conversion.convertBooleanToString(venue.getFireworksPlanned());
                        break;
                    case "fireworks cost":
                        data[headersMap.get(key)] = conversion.convertDoubleToString(venue.getFireworksCost());
                        break;
                    default:
                        System.out.println("Header not found.");
                        break;
                }
            }
            //! Add new event.
            eventData.add(data);
            //! Store to file data storage.
            fileDataStorage.setEventFileData(eventData);

        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(ArrayIndexOutOfBoundsException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }


    /**
     * Description: This method creates the new event.
     */
    public void addEvent(){

        //! Get max event ID and print.
        int maxID = ConfigureEventDetails.getMaxID()+1;
        System.out.println("Create event for ID: " + maxID);
        
        //! Create the new event.
        createVenue();
        getTempEvent().setEventID(maxID);
        getTempEvent().setEventName(createEventName());
        getTempEvent().setDate(createDate());
        getTempEvent().setTime( createTime());

        //! Create node for new event data.
        NodeData tempNode = new NodeData(getTempEvent(), getTempTickets());

        //! Store event data in the hashMap.
        ConfigureEventDetails.getEventDataMap().put(maxID, tempNode);
        //! Store the name data in the hashMap.
        ConfigureEventDetails.getEventNameMap().put(tempNode.getEventData().getEventName().toLowerCase(), maxID);
        //! Update max ID.
        ConfigureEventDetails.setMaxID(maxID+1);

        //! Get the node created.
        NodeData node = ConfigureEventDetails.getEventDataMap().get(maxID);

        node.getEventData().printEventData(node.getTicketsData());
        //! Store to arrayList.
        addToEventArray(node);

        //! Update to new event excel file.
        CSVUpdateHandler csvUpdateHandler = new CSVUpdateHandler();
        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
    }


    /**
     * Description: This method creates the event name for the new event to be added.
     * @return create the event name for the new event
     */
    public String createEventName(){

        String[] eventName;
        String newName = "";
        
        try {
            while(true){
                System.out.println("Input event name");
                System.out.print(">> ");
                //! remove excessive white space and leading and trailing white space.
                eventName = new Scanner(System.in).nextLine().trim().split("[ ]+");
    
                //! Join to a new string with single space in between letters.
                newName = String.join(" ", eventName);

                //! Check if the name exist, if not return the new name, else prompt again.
                if(ConfigureEventDetails.getEventNameMap().get(newName.toLowerCase()) == null){
                    return newName;
                }
                else    
                    System.out.println("Event name already exist.");
            }
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return newName;
    }

    /**
     * Description: This method create a date for the new event to be added.
     * @return The date.
     */
    public String createDate(){

        //! Create helper objects.
        UserInputHandler userInputHandler = new UserInputHandler();
        DateAndTimeHandler dateAndTimeHandler = DateAndTimeHandler.getInstance();
        MenuHandler menuHandler = new MenuHandler();

        String date = "";
        try {
            //! Run till valid data is inputted by admin.
            while (true) {
                //! Prompt for valid time. 
                menuHandler.dateMenu();
                //! Create reference.
                date = userInputHandler.timeOrDateHandler(new Scanner(System.in)).replace("[/\\s]+", "");

                //! Check if valid time and return.
                if(dateAndTimeHandler.checkDate(date)){
                    String [] newDateArray = date.split("[/\\s]+");
                    String  newDate = String.join("/", newDateArray);

                    if(newDate.substring(0,1).equalsIgnoreCase("/"))
                        return newDate.substring(1);
                    else    
                        return newDate;
                }     
            }
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(InputMismatchException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return "";
    }

    /**
     * Description: This method creates and returns a valid time formate for the event.
     * @return The time string for the event being created.
     */
    public String createTime(){

        //! Create objects.
        UserInputHandler userInputHandler = new UserInputHandler();
        MenuHandler menuHandler = new MenuHandler();

        //! Create reference.
        DateAndTimeHandler dateAndTimeHandler = DateAndTimeHandler.getInstance();

        //! Initialize time to empty string.
        String time = "";
        try {
            //! Run till user inputs valid time formate.
            while (true) {
                //! Prompt fot time menu and input time.
                menuHandler.timeMenu();
                time = userInputHandler.timeOrDateHandler(new Scanner(System.in)).replace("[:\\s]+", "");

                //! Check if formate of time is valid.
                if(dateAndTimeHandler.checkTime(time))
                {
                    //! Split by (:) and join to new string.
                    String [] timeArray = time.split("[:\\s]+");
                    String newTime = String.join(":", timeArray);

                    //! Check if first character is (:), if so remove it else return the new time with correct (am or pm).
                    if(newTime.substring(0,1).equalsIgnoreCase(":"))
                        return newTime.substring(1) + amORpm();
                    else    
                        return newTime + amORpm();
                }
            }
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(InputMismatchException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return "";
    }

    /**
     * Description: This method prompts and returns a string of either am or pm for time.
     * @return The string am or pm.
     */
    public String amORpm(){
        //! Initialize formate (am or pm)/
        String formate = "AM";
        try {
            //! Runs till valid input is made.
            while (true) {
                //! Prompt user and store inputted data.
                System.out.println("Type AM or PM");
                formate = new Scanner(System.in).nextLine();
                //! Check if am or pm and return the string.
                if(formate.equalsIgnoreCase("AM"))
                    return " AM";
                if(formate.equalsIgnoreCase("PM"))
                    return " PM";
            }
        } catch (InputMismatchException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return formate;

        


    }


    /**
     * Description: This method creates the appropriate child objects of event parent class and returns the cost for venue.
     * @param venueName Holds venue name
     * @return The cost for the venue/event.
     */
    public double createTypeOfEvent(String venueName){

        //! For user input.
        UserInputHandler userInputHandler = new UserInputHandler();
        //! Holds venue cost.
        double venueCost = 0.0;

        //! Create appropriate event child objects based on venue name.
        try {
            System.out.println("What type of event do you want?");

            if(venueName.equalsIgnoreCase("Sun Bowl Stadium")){
                //! Prompt user for type of event.
                System.out.println("1: Sport\n2: Concert");
                System.out.print(">> ");
                int eventOption = userInputHandler.isInRange(new Scanner(System.in), 1, 2);
                //! Create object based on feedback.
                if(eventOption == 1){
                    setTempEvent(getEventFactory().createEvent("Sport"));
                    getTempEvent().setEventType("Sport");
                    venueCost = 681500;
                }
                else if(eventOption == 2){
                    setTempEvent(getEventFactory().createEvent("Concert"));
                    getTempEvent().setEventType("Concert");
                    venueCost = 752000;
                }
            }
            if(venueName.equalsIgnoreCase("Don Haskin Center")){
                //! Prompt user type of event.
                System.out.println("1: Sport\n2: Concert\n3: Festival");
                System.out.print(">> ");
                int eventOption = userInputHandler.isInRange(new Scanner(System.in), 1, 3);
                //! Create object based on feedback and set the capacity based on venue object.
                if(eventOption == 1){
                    setTempEvent(getEventFactory().createEvent("Sport"));
                    getTempEvent().setEventType("Sport");
                    venueCost = 150400;
                }
                else if(eventOption == 2){
                    setTempEvent(getEventFactory().createEvent("Concert"));
                    getTempEvent().setEventType("Concert");
                    venueCost = 164500;
                }
                else if(eventOption == 3){
                    setTempEvent(getEventFactory().createEvent("Festival"));
                    getTempEvent().setEventType("Festival");
                    venueCost = 150400;
                }
            }
            if(venueName.equalsIgnoreCase("Magoffin Auditorium")){
                //! Just create Concert object.
                setTempEvent((getEventFactory().createEvent("Concert")));
                getTempEvent().setEventType("Concert");
                venueCost = 13536;
            }
            if(venueName.equalsIgnoreCase("San Jacinto Plaza")){
                //! Just  create Festival object.
                setTempEvent((getEventFactory().createEvent("Festival")));
                getTempEvent().setEventType("Festival");
                venueCost = 176250;
            }
            if(venueName.equalsIgnoreCase("Centennial Plaza")){
                //! Just create Festival object.
                setTempEvent((getEventFactory().createEvent("Festival")));
                getTempEvent().setEventType("Festival");
                venueCost = 58750;
            }
            
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        return venueCost;

    }

    /**
     * Description: This method created the venue object and anything related to venue.
     */
    public void createVenue(){
        UserInputHandler userInputHandler = new UserInputHandler();
        MenuHandler menuHandler = new MenuHandler();

        //! Prompt for venue name.
        menuHandler.venueNameMenu();
        int selectedVenue = userInputHandler.isInRange(new Scanner(System.in), 1, 5);
        double venueCost;

        //! Populate the venue and event with data user data and pragmatically data.
        switch(selectedVenue){
            case 1: 
            
                venueCost = createTypeOfEvent("Sun Bowl Stadium");

                getTempEvent().setVenue(getVenueFactory().createVenue("Stadium"));

                getTempEvent().getVenue().setVenueType("Stadium");

                getTempEvent().getVenue().setVenueCost(venueCost);
            
                getTempEvent().getVenue().setVenueName("Sun Bowl Stadium");
                getTempEvent().getVenue().setVenueCapacity(64000);

                getTempTickets().setTicketsAnalytics(createSeats("Sun Bowl Stadium"));
                break;
            case 2:
            
                venueCost = createTypeOfEvent("Don Haskin Center");
                getTempEvent().setVenue(getVenueFactory().createVenue("Arena"));

                getTempEvent().getVenue().setVenueType("Arena");

                getTempEvent().getVenue().setVenueCost(venueCost);

                getTempEvent().getVenue().setVenueName("Don Haskin Center");
                getTempEvent().getVenue().setVenueCapacity(12800);

                getTempTickets().setTicketsAnalytics(createSeats("Don Haskin Center"));
                break;
            case 3:
            
                venueCost = createTypeOfEvent("Magoffin Auditorium");
                getTempEvent().setVenue(getVenueFactory().createVenue("Auditorium"));

                getTempEvent().getVenue().setVenueType("Auditorium");

                getTempEvent().getVenue().setVenueCost(venueCost);

                getTempEvent().getVenue().setVenueName("Magoffin Auditorium");
                getTempEvent().getVenue().setVenueCapacity(1152);

                getTempTickets().setTicketsAnalytics(createSeats("Magoffin Auditorium"));
                break;
            case 4:
            
                venueCost = createTypeOfEvent("San Jacinto Plaza");
                getTempEvent().setVenue(getVenueFactory().createVenue("Open Air"));

                getTempEvent().getVenue().setVenueType("Open Air");

                getTempEvent().getVenue().setVenueCost(venueCost);

                getTempEvent().getVenue().setVenueName("San Jacinto Plaza");
                getTempEvent().getVenue().setVenueCapacity(15000);

                getTempTickets().setTicketsAnalytics(createSeats("San Jacinto Plaza"));
                break;
            case 5:

                venueCost = createTypeOfEvent("Centennial Plaza");
                getTempEvent().setVenue(getVenueFactory().createVenue("Open Air"));
                
                getTempEvent().getVenue().setVenueType("Open Air");

                getTempEvent().getVenue().setVenueCost(venueCost);

                getTempEvent().getVenue().setVenueName("Centennial Plaza");
                getTempEvent().getVenue().setVenueCapacity(5000);

                getTempTickets().setTicketsAnalytics(createSeats("Centennial Plaza"));
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }   

    /**
     * Description: This method creates the Ticket analytics data for the event created.
     * @param venueName holds Venue name.
     * @return The ticket analytics object for event.
     */
    public TicketAnalytics createSeats(String venueName){
        TicketAnalytics ticketAnalytics = new TicketAnalytics();

        //! Set PCT and ticket prices.
        setPCT();
        createTicketPrices();

        //! Set the ticket Analytics for event created.
        switch (venueName) {
            case "Sun Bowl Stadium":
                ticketAnalytics = TicketAnalyticsMaker.createAnalytics(getTempEvent().getVenue(), getTempTickets());
                break;
            case "Don Haskin Center":
                ticketAnalytics = TicketAnalyticsMaker.createAnalytics(getTempEvent().getVenue(), getTempTickets());
                break;
            case "Magoffin Auditorium":
                ticketAnalytics = TicketAnalyticsMaker.createAnalytics(getTempEvent().getVenue(), getTempTickets());
                break;
            case "San Jacinto Plaza":
                ticketAnalytics = TicketAnalyticsMaker.createAnalytics(getTempEvent().getVenue(), getTempTickets());
                break;
            case "Centennial Plaza":
                ticketAnalytics = TicketAnalyticsMaker.createAnalytics(getTempEvent().getVenue(), getTempTickets());
                break;
            default:
                System.out.println("There is an error");
        } 
        return ticketAnalytics;
    }

    /**
     * Description: This method sets the PCT for each ticket type.
     */
    public void setPCT(){

        try {
            //! Store the PCT for each ticket type
            getTempEvent().getVenue().setVipPct(5);
            getTempEvent().getVenue().setGoldPct(10);
            getTempEvent().getVenue().setSilverPct(15);
            getTempEvent().getVenue().setBronzePct(20);
            getTempEvent().getVenue().setGeneralPct(45);
            getTempEvent().getVenue().setReservedExtraPct(5);
            
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: THis method creates and sets the ticket prices for each ticket type.
     */
    public void createTicketPrices(){
        UserInputHandler userInputHandler = new UserInputHandler();
        MenuHandler menuHandler = new MenuHandler();

        //! Print ticket price menu.
        menuHandler.ticketPriceMenu();
        try {  
            //! Prompt user input for GA, then programmatically set the other ticket prices.
            double price = userInputHandler.isInRange(new Scanner(System.in), 0, 4000);
            getTempTickets().setGeneralAdmissionPrice(price);
            getTempTickets().setBronzePrice(price * 1.5);
            getTempTickets().setSilverPrice(price * 2.5);
            getTempTickets().setGoldPrice(price * 3);
            getTempTickets().setVipPrice(price * 5);

            //! Set the array list of ticket names, prices.
            getTempTickets().setTicketNames();
            getTempTickets().setTicketPrices(); 
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }catch(InputMismatchException e){
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

}
