package main;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author Walter Wawra
 * @author Fernando Remes
 * @author Raul Pallares
 * @author Zachary Wittmann
 * @since 11/2/2023
 * Description: Class to determine if the user is an admin or a customer.Everything in the class and method were refactored and collaborated together via live share.
 */
public class AdminOrCustomer {

    /**
     * Description: chooseAdminOrCustomer() will prompt the user to choose if they are an admin or a customer.
     * @return The boolean
     */
    public int chooseAdminOrCustomer() {
        //! For user input.
        Scanner someScanner = new Scanner(System.in);
        UserInputHandler userInputHandler = new UserInputHandler();
        //! Holds user choice.
        int isAdmin = 0;
        try{
            //! Chose if admin, customer or exit.
            int choice = userInputHandler.isInRange(someScanner, 1, 3);
            
            switch(choice){
                case 1: 
                    isAdmin = 1;
                    break;
                case 2:
                    isAdmin = 2;
                    break;
                case 3:
                    CSVUpdateHandler csvUpdateHandler = new CSVUpdateHandler();
                    csvUpdateHandler.createUpdatedEventFile("NewEventList.csv");
                    csvUpdateHandler.createUpdatedCustomerFile("NewCustomerList.csv");
                    isAdmin = 3;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println(">> ");
                    break;
            }
        }
        catch (InputMismatchException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);

            System.out.println("Invalid choice. Please try again.");
            System.out.println(">> ");
        }
        //! Return choice.
        return isAdmin;
    }
}
