package main;
/**
 * Description: This class is an abstract class. It is a general person that everyone has in common. It will let its children dill with storing the data of a customer.
 * @author Raul Pallares
 * @since 9/19/2023
 */
public abstract class Person {
    
    //! General attributes for a person
    private String firstName;
    private String lastName;


    /**
     * Description: This gets the first name of a person
     * @return The first name of a person
     */
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * Description: This sets the first name of a person
     * @param firstName Set the first name of a person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Description: This gets the last name of a person
     * @return The last name of a person
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * Description: This sets the last name of a person
     * @param lastName Set the last name of a person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
