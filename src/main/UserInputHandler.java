package main;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Description: This class is a helper class for the admin method. It will handle user input related content.
 * @author Raul Pallares
 * @author Fernando Remes
 * @since 10/17/2023
 */
public class UserInputHandler {
    

    /**
     * Description: Default constructor.
     */
    public UserInputHandler(){}



    /**
     * Description: Check the user input for the main menu prompt return the string back to main.From Raul.
     * @param genericScanner Used to read suer input
     * @return The String data type
     */
    public String getValidUserInput(Scanner genericScanner){
        //! Initialize input string.
        String menuInput = "";

        while (true) {
            //! Read user input and ignore white space.
            menuInput = genericScanner.nextLine().trim().toLowerCase();
            //! Check if option is valid to search option. If so return the string in lower case.
            if(menuInput.equalsIgnoreCase("search"))
                return menuInput;
        }
    }


    /**
     * Description: This method prompts customer of want to continue to search.
     * @param genericScanner holds scanner object.
     * @return The string choice of the customer.
     */
    public String getYesNoInput( Scanner genericScanner){
        //! Prompt user for either yes or no and return the string.
        String userInput = "";
        while (true) {
            userInput = genericScanner.next().toLowerCase();


            if(userInput.equalsIgnoreCase("YES"))
                return userInput;
            else if (userInput.equalsIgnoreCase("NO"))
                return userInput;
        }
    }
    
    
    
    /**
     * Description: Check if user entered a an integer data type and continue to prompt the use till they enter an integer type. From Raul.
     * @param genericScanner Used to read user input
     * @return The integer number data type
     */
    public int isValidInteger(Scanner genericScanner){

        //! Run till user enters an integer type.
        while(true){
            try {
                //! Clear screen.
                //FlushScreen.flushScreen();
                //! Return the integer type else cath the exception of different data type.
                return genericScanner.nextInt();
            } catch (InputMismatchException e) {
                //! Log the exception that happened.
                ExceptionLogger.logExceptionsThrown(e);

                System.out.println("Please enter valid Integer option");
                System.out.print(">> ");
                //! Ignore current input read.
                genericScanner.nextLine();
            }
        }
    }
    
    /**
     * Description: Check if the inputted integer value from user is in range return the integer. From Raul.
     * @param genericScanner Used to read user input
     * @param minNum Represents the min range of a number
     * @param maxNum Represent the max range of a number
     * @return The integer number data type
     */
    public int isInRange(Scanner genericScanner, int minNum, int maxNum){

        //! Run until user enters valid in range input.
        while(true){
            //! Clear screen.
           // FlushScreen.flushScreen();
            //! Prompt user for integer type and store integer
            int inRangeNumber = isValidInteger(genericScanner);
            //! clear input read.
            genericScanner.nextLine();

            //! Check if number is in range and if so return the number.
            if((inRangeNumber >= minNum) && (inRangeNumber <= maxNum))
                return inRangeNumber;
            //! Prompt user again if number not in range.
            System.out.println("Please enter valid in range integer option");
            System.out.print(">> ");

        }
    }


    /**
     * Description: This method is for prompting user for either searching for an event ID or name
     * @param s Holds scanner for user input.
     * @return handle the inquiry option of A for event id, B event by name. From Fernando.
     */
    public String inquiryHandler(Scanner s){
        //! Run as long and user does not enter a or b. 
        String input = "";
        while(true){
            try{
                //! Clear screen.
               // FlushScreen.flushScreen();
                input = s.nextLine();
                if(input.equalsIgnoreCase("A") || input.equalsIgnoreCase("B")){
                    break;
                }
                else{
                    System.out.println("Invalid Input");
                    System.out.print(">> ");
                    input = "";
                }
            }
            catch(InputMismatchException e){
                //! Log the exception that happened.
                ExceptionLogger.logExceptionsThrown(e);

                System.out.println("Invalid Input\n");
                System.out.print(">> ");
            }        
        }
        return input;
    }

    /**
     * Description: This method is for prompting user input if wna tto buy ticket.
     * @param s Holds Scanner
     * @return The true or false.
     */
    public boolean buyTicketHandler(Scanner s){
        //! Run a long as user does not enter yes = true or exit = false.
        while(true){
            //! Clear screen.
            //FlushScreen.flushScreen();
            String userInput = s.nextLine().trim();
            try {
                if(userInput.equalsIgnoreCase("yes")){
                    return true;    
                } else if(userInput.equalsIgnoreCase("exit")){
                    return false;
                }else{
                    System.out.println("Invalid Input");
                    System.out.print(">> ");
                }
            } catch (InputMismatchException e) {
                //! Log the exception that happened.
                ExceptionLogger.logExceptionsThrown(e);

                System.out.println("Invalid Input");
                System.out.print(">> ");
            } 
        }
    }
    /**
     * Description:
     * @param genericScanner
     * @return the input 
     */
    public String timeOrDateHandler(Scanner genericScanner){
        try {
            return genericScanner.nextLine();
        } catch (InputMismatchException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
            
            System.out.println("Invalid input");
            System.out.print(">> ");
        }
        return "";
    }



}

