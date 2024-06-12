package main;

/**
 * Description: This is a creational design pattern, it is called a factory design pattern.
 * We decided to use fernando's code for the Event factory class. It is separate from a venue factory class.
 * @author Fernando Remes
 * @since 10/11/2023
 */
public class EventFactory {
    

    /**
     * Description: Default constructor
     */
    public EventFactory(){}




    /**
     * Description: This is a creational design pattern. It creates the children objects of the Event parent class.
     * method code came from both raul and fernando.
     * @param eventType Used for creating object 
     * @return the created object (sport, festival, concert)
     */
    public Event createEvent(String eventType){
        //! Check if event type is either Sport, Concert or Festival and create correct objects to hold the data.
        if(eventType.equalsIgnoreCase("Sport")){
            return new Sport();
        }
        else if(eventType.equalsIgnoreCase("Concert")){
            return new Concert();
        }
        else if(eventType.equalsIgnoreCase("Festival")){
            return new Festival();
        }
        else{
            return null;
        }
    }

}
