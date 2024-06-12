package main;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Description: This class is only for an admin to use. It will allow the admin to modify data from a specified event for customer.From Raul.
 * @author Raul Pallares
 * @since 10/1/2023
 */
public class AdminEventModifier {

    /**
     * Description: Default constructor.
     */
    public AdminEventModifier(){}

    /**
     * Description: A method for modifying the price of the event.
     * @param name Event names from file 
     * @return the changed data the user inputted
     */
    public double changePrice(String genericName){
        //! For user input.To change the specified data.
        Scanner changedDataInput = new Scanner(System.in);

        //! Run till receive a double data type
        while(true){
            FlushScreen.flushScreen();
            try {
                //! Prompt user what they choose and to change.
                System.out.println("\nInput new " + genericName);
                System.out.print(">> ");

                //! Return the data the user entered else catch exception of other data type.
                return changedDataInput.nextDouble();
            } catch (InputMismatchException e) {
                //! Log exception that happened.
                ExceptionLogger.logExceptionsThrown(e);
                System.out.println("Please enter valid input");
                //! Ignore current input read
                changedDataInput.next();
            }
        }
    }

    /**
     * Description: This method changes the date for the event.
     * @return The date.
     */
    public String changeDate(){

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
     * Description: This method changes and returns a valid time formate for the event.
     * @return The time string for the event being changed.
     */
    public String changeTime(){

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
     * Description: This method changes the event name form the event we are in.
     * @return create the event name for the new event
     */
    public String changeEventName(String genericName){

        String[] eventName;
        String newName = "";
        
        try {
            while(true){
                System.out.println("Input new event " + genericName);
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
        //! Return the name.
        return newName;
    }

    /**
     * Description: This method is used by an admin they can modify event details for an event.
     * @param nodeData Holds the event detail of an event.
     * @param logger Holds the logger to write admins action to a txt file.
     */
    public void selectedToModify(NodeData nodeData, AdminLogger logger){
        try {
            //! Store event and ticket data.
            Event eventData = nodeData.getEventData();
            TicketsHandler ticketData = nodeData.getTicketsData();

            //! Create input Handler object to handle user input.
            UserInputHandler inputHandler = new UserInputHandler();
            //! Create menuHandler to get admin menus.
            MenuHandler menuHandler = new MenuHandler();

            //! For updating to new csv file.
            CSVUpdateHandler csvUpdateHandler = new CSVUpdateHandler();

            //! A flag to determine when to exit.
            boolean isExit = false;

            //! The user choice to modify.
            int modifyChoice;
            //! Holds the price.
            double ticketPrice;
            //! Store before change.
            String originalName;

            //! While false.
            while(!isExit){
                //! Print menu to modify.
                menuHandler.modifyMenu();
                //! Prompt admin.
                menuHandler.AdminPrivilegesMenu(nodeData);
                System.out.println("9: to return");
                System.out.print(">> ");

                

                //! Get user choice.
                modifyChoice = inputHandler.isValidInteger(new Scanner(System.in));
                //! Go to user choice and modify the contents.
                //! Store original name, modify data selected and log it to a txt file.
                switch(modifyChoice){

                    case 1: 
                        originalName = eventData.getEventName();
                        eventData.setEventName(changeEventName("name"));
                        logger.loggingModifiedEvent(nodeData, "name", originalName ,eventData.getEventName());
                        //! Get the key ID.
                        int key =  ConfigureEventDetails.getEventNameMap().get(originalName.toLowerCase());

                        //! Remove the key/value pair from the hashMap.
                        ConfigureEventDetails.getEventNameMap().remove(originalName.toLowerCase());
                        //! Added new event name with the key pair in the hashMap.
                        ConfigureEventDetails.getEventNameMap().put(nodeData.getEventData().getEventName().toLowerCase(), key);
                        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                        break;
                    case 2:
                        originalName = eventData.getDate();
                        eventData.setDate(changeDate());
                        logger.loggingModifiedEvent(nodeData, "date", originalName, eventData.getDate());
                        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                        break;
                    case 3:
                        originalName = eventData.getTime();
                        eventData.setTime(changeTime() );
                        logger.loggingModifiedEvent(nodeData, "time", originalName, eventData.getTime());
                        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                        break;
                    case 4:
                        originalName = String.valueOf(ticketData.getVipPrice());
                        ticketPrice = changePrice("vip price");
                        ticketData.setVipPrice(ticketPrice);
                        ticketData.getTicketPrices().set(1, ticketPrice);
                        logger.loggingModifiedEvent(nodeData, "vip price", originalName, String.valueOf(ticketData.getVipPrice()));
                        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                        break;
                    case 5:
                        originalName = String.valueOf(ticketData.getGoldPrice());
                        ticketPrice = changePrice("gold price");
                        ticketData.setGoldPrice(ticketPrice);
                        ticketData.getTicketPrices().set(2, ticketPrice);
                        logger.loggingModifiedEvent(nodeData, "gold price", originalName, String.valueOf(ticketData.getGoldPrice()));
                        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                        break;
                    case 6:
                        originalName = String.valueOf(ticketData.getSilverPrice());
                        ticketPrice = changePrice("silver price");
                        ticketData.setSilverPrice(ticketPrice);
                        ticketData.getTicketPrices().set(3, ticketPrice);
                        logger.loggingModifiedEvent(nodeData, "silver price", originalName, String.valueOf(ticketData.getSilverPrice()));
                        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                        break;
                    case 7:
                        originalName = String.valueOf(ticketData.getBronzePrice());
                        ticketPrice = changePrice("bronze price");
                        ticketData.setBronzePrice(ticketPrice);
                        ticketData.getTicketPrices().set(4, ticketPrice);
                        logger.loggingModifiedEvent(nodeData, "bronze price", originalName, String.valueOf(ticketData.getBronzePrice()));
                        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                        break;
                    case 8:
                        originalName = String.valueOf(ticketData.getGeneralAdmissionPrice());
                        ticketPrice = changePrice("general admission price");
                        ticketData.setGeneralAdmissionPrice(ticketPrice);
                        ticketData.getTicketPrices().set(5, ticketPrice);
                        logger.loggingModifiedEvent(nodeData, "general admission price", originalName, String.valueOf(ticketData.getGeneralAdmissionPrice()));
                        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                        break;
                    case 9:
                        isExit = true;
                        logger.loggingAdminsSearch(nodeData);
                        csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                        break;
                }
            }
        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } finally{
            FlushScreen.flushScreen();
            System.out.println("returning ...");
        }
    }
}
