package main;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * Description: This class is only for admins. It is meant to log the admins actions to a txt file. From Raul
 * @author Raul Pallares
 * @since 10/12/2023
 */
public class AdminLogger {
    
    //! Store filename.
    private String filename;


    //! For accessing logger framework.
    private static Logger logger = Logger.getLogger(AdminLogger.class.getName());

    private FileHandler fileHandler;

    /**
     * Description: Default constructor.
     */
    public AdminLogger(){}

    /**
     * Description: Constructor, sets the file name.
     * @param filename Holds the name of the file.
     */
    public AdminLogger(String filename){
        setFilename(filename);
    }


    /**
     * Description: Get the name of the file.
     * @return The file name
     */
    public String getFilename() {
        return this.filename;
    }
    /**
     * Description: Set the name of the file.
     * @param filename Holds the file name
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Description: Get the logger
     * @return The logger data.
     */
    public static Logger getLogger() {
        return logger;
    }
    /**
     * Description: Set the logger data.
     * @param logger Holds logger data.
     */
    public static void setLogger(Logger logger) {
        AdminLogger.logger = logger;
    }

    /**
     * Description: Get the file handler.
     * @return The object
     */
    public FileHandler getFileHandler() {
        return this.fileHandler;
    }

    /**
     * Description: Set file handler.
     * @param fileHandler Holds object.
     */
    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }


    public synchronized void configureAdminDirectory(){
        try {
        //! Get the path and make or open directory.
        File adminLogger = new File("AdminLogger");
        adminLogger.mkdir();

        } catch (Exception e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: THis method sets up the Admin logger to track Admin actions.
     */
    public synchronized void configureAdminLogger(){

        try {
            //! Do not write to terminal.
            getLogger().setUseParentHandlers(false);

            //! Get the file specified.
            setFileHandler(new FileHandler("AdminLogger/" + getFilename(), true));
            //! For readability in .txt file.
            getFileHandler().setFormatter(new SimpleFormatter());
            //! Allows us to use config, finer etc.
            getLogger().setLevel(Level.ALL);
            //! Store teh fileHandler to write to file.
            getLogger().addHandler(getFileHandler());
        } catch (Exception e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }
    /**
     * Description: This method Closes file handlers when done.
     */
    public synchronized void closeLogger(){
        //! Run and close file handler.
        if(getFileHandler() != null)
            getFileHandler().close();
    }



    /**
     * Description: This method logs what the admin search.
     * @param nodeData Holds data for the event.
     */
    public synchronized void loggingAdminsSearch(NodeData nodeData){

        try {
            //! Store event data.
            Event eventData = nodeData.getEventData();

            //! Log to .txt file.
            getLogger().info("Admin viewed the an event ID " + eventData.getEventID() + ". The event name was " + eventData.getEventName() + "\n") ;

        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }

    /**
     * Description: This method logs the admin functionality chosen.
     * @param choice Holds the options chosen.
     */
    public synchronized void logAdminChoice(String choice){
        getLogger().info("Admin selected the option called " + choice + "\n");
    }


    public synchronized void logInquiry(String letter, int eventID){

        try {
            //! Log to .txt file.
            getLogger().info("Administrator selected \""+  letter  +  "\"\nSystem gave information from event id #" + eventID + " to the Administrator \n");

        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }




    /**
     * Description: This method logs what the admin changed from the event.
     * @param nodeData Holds the data for the event.
     * @param eventName Holds the name of the event.
     * @param originalName Holds the original name.
     * @param newName Holds the new name.
     */
    public synchronized void loggingModifiedEvent(NodeData nodeData, String eventName ,String originalName, String newName){
        try {
            //! Get event Data.
            Event eventData = nodeData.getEventData();

            //! Log to .txt file.
            getLogger().info("Admin viewed Event ID " + eventData.getEventID() + " and updated " + eventName + " from " + originalName + " to " + newName + "\n");

        } catch (NullPointerException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }


    }



    /**
     * Description: Method to clear a file of existing contents/data. File is a txt file for admin.
     */
    public void flushAdminFile(){
        try {

            //! Get admin file to write to.
            FileOutputStream fileOut = new FileOutputStream("AdminLogger/" + getFilename());

            //! Used to write to the admin file we passed in constructor.
            PrintWriter printWriter = new PrintWriter(fileOut);

            //! Clear the contents in the admin file.
            printWriter.println(" ");

            //! Writes data quickly to the admin file.
            printWriter.flush();

            //! When done writing to admin file, close fileOutputStream.
            fileOut.close();

        } catch (IOException e) {
            //! Log exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }





}



