package main;
/**
 * Description: This class is used to clear the terminal.
 * @author Extreme Software Development LLC
 */
public class FlushScreen {
    
    /**
     * Description: Default Constructor
     */
    public FlushScreen(){}

    /**
     * Description: This method clears the terminal.
     */
    public static  synchronized void flushScreen(){
        //! Clear screen.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
