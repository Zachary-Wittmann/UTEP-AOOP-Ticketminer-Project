package main;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Description: This class is a helper class for main. Its only task is to search for an event either by name or by event ID.  
 * @author Raul Pallares
 * @author Fernando Remes
 * @since 10.18.2023
 */
public class SearchEvent {
    

    /**
     * Description: Default Constructor.
     */
    public SearchEvent(){}


    /**
     * Description: This method searches for an event and returns the event data as a node.
     * @param letter Holds letter from user option.
     * @param userInputHandler Holds object for user input.
     * @return The node data of the event.
     */
    public NodeData eventSearch(String letter, UserInputHandler userInputHandler){
        //! Initialize to null.
        NodeData node = null;
        try {
            //! Check if user chose A, search by event ID.
            if(letter.equalsIgnoreCase("A")){

                //! get range or event ID.
                int minNum = 1;
                int maxListSize = ConfigureEventDetails.getMaxID();

                //! Run till found
                while(true){
                    //! Clear screen.
                    // FlushScreen.flushScreen();
    
                    //! Search for event specified by user.
                    System.out.println("\nPlease enter valid event ID between (" + minNum + "-" + maxListSize +") to search");
                    System.out.print(">> ");
    
                    //! Retrieve the event details by searching by ID.
                    node = ConfigureEventDetails.getEventDataMap().get(userInputHandler.isInRange(new Scanner(System.in), minNum, maxListSize));

                    //! Check if event not canceled and if so return the node else prompt user again.

                    if(node != null && !node.getEventData().getIsCanceled()) {
                        break;
                    }
                    else {
                        System.out.println("Event is canceled.");
                    }    
                }

            }   
            //! ELse, check if user chose to search by event name.
            else if (letter.equalsIgnoreCase("B")){
                //! Holds user input for event name.
                String []eventNameInput;
                String eventName;

                //! Run as long as an event is not found.
                while(true){
                    //! Clear screen.
                    //FlushScreen.flushScreen();
                    System.out.println("\nPlease enter a valid event name");
                    System.out.print(">> ");

                    //! remove excessive white space and leading and trailing white space.
                    eventNameInput = new Scanner(System.in).nextLine().trim().split("[ ]+");

                    //! Join to a new string with single space in between letters.
                    eventName = String.join(" ", eventNameInput);
                    
                    //! FOr storing the Event ID.
                    int key; 
                    //! Check if inputted name is found. If so get the  event ID-> key and ge the node event data.
                    if(ConfigureEventDetails.getEventNameMap().get(eventName.toLowerCase()) != null){
                        key = ConfigureEventDetails.getEventNameMap().get(eventName.toLowerCase());
                        node = ConfigureEventDetails.getEventDataMap().get(key);

                        //! Check if event is canceled. IF so prompt again else return the node.
                        if(!node.getEventData().getIsCanceled())
                            break;
                        else    
                            System.out.println("Event is canceled.");
                    }
                }
            }
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(InputMismatchException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } finally{
            //! Return null by default.
            return node;
        }
    }

}
