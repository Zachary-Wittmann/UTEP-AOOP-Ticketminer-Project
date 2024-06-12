package main;
import java.util.ArrayList;
/**
 * Description: This class is meant to store the data that was read in from an excel file once so that it can be used at the end of program. 
 * This class implements a singleton design pattern. Class and methods came from Raul.
 * @author Raul Pallares
 * @since 9/29/2023
 */
public class FileDataStorage {


    //! Static is Global -> Can be accessed from outside the class.
    private static FileDataStorage fileDataStorage;

    //! An array list to hold the data read from event file.
    private ArrayList<String[]> eventFileData = new ArrayList<>();

    //! An array list to hold the data read in from customer file.
    private ArrayList<String[]> customerFileData = new ArrayList<>();


    /**
     * Description: Default Constructor, Creating singleTon design pattern in a special way.
     */
    private FileDataStorage(){}

    /**
     * Description: Get the file data for event.
     * @return the array that holds the data.
     */
    public ArrayList<String[]> getEventFileData() {
        return this.eventFileData;
    }
    /**
     * Description: Set the file data for event.
     * @param eventFileData Holds the data for the event.
     */
    public void setEventFileData(ArrayList<String[]> eventFileData) {
        this.eventFileData = eventFileData;
    }

    /**
     * Description: Get the data for the customer.
     * @return  the customer data.
     */
    public ArrayList<String[]> getCustomerFileData() {
        return this.customerFileData;
    }
    /**
     * Description: Set the customer data.
     * @param customerFileData Holds the customer data.
     */
    public void setCustomerFileData(ArrayList<String[]> customerFileData) {
        this.customerFileData = customerFileData;
    }

    /**
     * Description: This method gets the instance of fileDataStorage (singleton design pattern).
     * synchronized is so we do not access the same object at the same time.
     * @return The fileDataStorage object.
     */
    public static synchronized FileDataStorage getInstance(){
        //! If object not created, create it.
        if(fileDataStorage == null)
            fileDataStorage = new FileDataStorage();
        //! Return the object.
        return fileDataStorage;
    }


}
