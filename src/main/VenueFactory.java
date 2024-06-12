package main;

/**
 * Description: This is a creational design pattern. It is called a factory design pattern.
 * We decided to use fernando venue factory class. It is separate from the event factory class.
 * @author Fernando Remes
 * @since 10/11/2023
 */
public class VenueFactory {
    

    /**
     * Description: Default Constructor.
     */
    public VenueFactory(){}



    /**
     * Description: This a creational design pattern. It creates the children objects of the Venue parent class.
     * Method code came from both raul and fernando.
     * @param venueType Used for creating object
     * @return The created object (Stadium, Arena, OpenAir, Auditorium)
     */
    public Venue createVenue(String venueType){
        //! Check if venue type is either Stadium, Arena, Auditorium or OpenAir and create correct objects to hold the data.
        if(venueType.equalsIgnoreCase("Stadium")){
            return new Stadium();
        }
        else if(venueType.equalsIgnoreCase("Arena")){
            return new Arena();
        }
        else if(venueType.equalsIgnoreCase("Open Air")){
            return new OpenAir();
        }
        else if(venueType.equalsIgnoreCase("Auditorium")){
            return new Auditorium();
        }
        else return null;
    }
}
