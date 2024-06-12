package main;

import java.util.Scanner;

/**
 * Description: This class handles the login process for the customer
 * @author Extreme Software Development Team LLC
 */
public class Login {

    /**
     * Description: Default Constructor.
     */
    public Login(){}

    /**
     * Description: Prompt user with choice of logging in.
     * @param scan the scanner.
     * @param menuHandler HOlds the menus.
     * @param userInputHandler Holds the user input handlers
     * @return How the user chose to log in (True for username/False for first and
     *         last name)
     */
    public Customer chooseLogIn(Scanner scan, MenuHandler menuHandler, UserInputHandler userInputHandler) {

        FlushScreen.flushScreen();
        menuHandler.chooseLogInMenu();

        int logInMethod = userInputHandler.isInRange(scan, 1, 2);
        Customer customer = null;
        switch (logInMethod) {
            case 1:
                // prompt for username and password
                customer = findByLogin(scan);
                break;
            case 2:
                customer = findByName(scan);
                break;
            default:
                System.out.println("Invalid choice, please choose 1 for Username or 2 for First and Last name.");
                System.out.print(">> ");
                break;
        }
        System.out.println("Login Successful!");
        return customer;
    }

    /**
     * Description: Find user by username and password.
     * @return the users login information
     * @param sc the scanner object
     */
    public Customer findByLogin(Scanner sc) {

        Customer customer = null;
        while(customer == null){
            System.out.print("Username: ");
            String username = sc.nextLine().trim();
            System.out.print("Password: ");
            String password = sc.nextLine().trim(); 
            customer = Customer.loggedInPassword(username, password);
        }
        return customer;
    }

    /**
     * Description: Find user by name
     * @return the users login information
     * @param sc the scanner object
     */
    public Customer findByName(Scanner sc) {
        Customer customer = null;
        while (customer == null) {
            System.out.print("First Name: ");
            String firstName = sc.next().trim().toLowerCase();
            System.out.print("Last Name: ");
            String lastName = sc.next().trim().toLowerCase();
            customer = Customer.loggedInName(firstName, lastName);
        }
        return customer;
    }
}