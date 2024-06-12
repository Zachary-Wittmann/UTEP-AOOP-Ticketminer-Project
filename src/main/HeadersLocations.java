package main;
import java.util.HashMap;

/**
 * Description: This class implements a singleton design pattern. This class is meant to hold two HashMaps, one for the event list and the other for the customer list.
 * I only need to create these HashMaps once doing reading in the file data. They are meant to store the key,header line and their respective value, columns index position in the file.
 * Class and methods came from Raul.
 * @author Raul Pallares
 * @since 9/29/2023
 */
public class HeadersLocations {
    

    //! Static is Global -> Can be accessed from outside the class.
    private static HeadersLocations  headers;

    //! A hashMap to hold where every single cell is located in the excel file.
    private HashMap<String, Integer> headerLocationEvent = new HashMap<>();

    //! A hashMap to hold where every single cell is located in the excel file.
    private HashMap<String, Integer> headerLocationCustomer = new HashMap<>();



    /**
     * Description: Default Constructor, Creating singleTon design pattern in a special way.
     */
    private HeadersLocations(){}


    /**
     * Description: This method gets the instance of HeaderLocations (singleton design pattern).
     * synchronized is so we do not access the same object at the same time.
     * @return The Header object.
     */
    public static synchronized HeadersLocations getInstance(){
        //! If object not created, create it.
        if(headers == null)
            headers = new HeadersLocations();
        //! Return the object.
        return headers;
    }

    /**
     * Description: This method gets the hasMap that has the locations of the header cells.
     * @return The hasMap reference.
     */
    public HashMap<String, Integer> getHeaderLocationEvent(){
        return this.headerLocationEvent;
    }
    /**
     * Description: Set header location data for event.
     * @param headerLocationEvent Holds header data for event.
     */
    public void setHeaderLocationEvent(HashMap<String, Integer> headerLocationEvent) {
        this.headerLocationEvent = headerLocationEvent;
    }


    /**
     * Description: This method gets the hasMap that has the locations of the header cells.
     * @return The hasMap reference.
     */
    public HashMap<String, Integer> getHeaderLocationCustomer(){
        return this.headerLocationCustomer;
    }
    
    /**
     * Description: Set the header locations for customers list.
     * @param headerLocationCustomer Holds header data.
     */
    public void setHeaderLocationCustomer(HashMap<String, Integer> headerLocationCustomer) {
        this.headerLocationCustomer = headerLocationCustomer;
    }
    

    /**
     * Description: This method clears any contents that were in the HashMap.
     */
    public void clearHashMapEvent(){
        headerLocationEvent.clear();
    }

    /**
     * Description: This method clears any contents that were in the HashMap.
     */
    public void clearHashMapCustomer(){
        headerLocationCustomer.clear();
    }

}
