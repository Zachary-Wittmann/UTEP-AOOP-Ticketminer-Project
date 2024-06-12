package main;
/**
 * Description: A child of the parent class of Person. Admin is different from a Customer class. An Admin had special privileges.From Raul.
 * @author Raul Pallares
 * @since 9/26/2023
 */
public class Admin extends Person{
    
    //! Only created if their is an admin for admin to modify event details.
    private AdminEventModifier adminEventModifier;
    //! Only created if their is an admin for logging their actions.
    private AdminLogger adminLogger;

    //! Only created if their is an admin for inquiry.From Raul and Fernando.
    private AdminInquiry adminInquiry;

    /**
     * Description: Default constructor
     */
    public Admin(){}

    /**
     * Description: Constructor, If there is an admin, set adminEventModifier  for the admin.
     * @param adminEventModifier Holds the object for admin modifier.
     * @param adminLogger Holds the object for the admin logger.
     * @param adminInquiry HOlds the object for the admin inquiry
     */
    public Admin(AdminEventModifier adminEventModifier, AdminLogger adminLogger, AdminInquiry adminInquiry){
        setAdminEventModifier(adminEventModifier);
        setAdminLogger(adminLogger);
        setAdminInquiry(adminInquiry);
    }

    /**
     * Description: Get the adminEventModifier object.
     * @return The object.
     */
    public AdminEventModifier getAdminEventModifier() {
        return this.adminEventModifier;
    }
    /**
     * Description: Set the adminEventModifier object.
     * @param adminEventModifier Holds the new object.
     */
    public void setAdminEventModifier(AdminEventModifier adminEventModifier) {
        this.adminEventModifier = adminEventModifier;
    }

    /**
     * Description: Get the adminLogger object.
     * @return The object.
     */
    public AdminLogger getAdminLogger() {
        return this.adminLogger;
    }
    /**
     * Description: Set the adminLogger object.
     * @param adminLogger Holds the new object.
     */
    public void setAdminLogger(AdminLogger adminLogger) {
        this.adminLogger = adminLogger;
    }

    /**
     * Description: Getter for admin inquiry object.
     * @return The admin inquiry object.
     */
    public AdminInquiry getAdminInquiry() {
        return this.adminInquiry;
    }
    /**
     * Description: Setter for admin inquiry object.
     * @param adminInquiry Holds object daa for inquiry.
     */
    public void setAdminInquiry(AdminInquiry adminInquiry) {
        this.adminInquiry = adminInquiry;
    }
}
