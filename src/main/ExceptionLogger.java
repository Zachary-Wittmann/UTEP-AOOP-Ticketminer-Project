package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author ESDT LLC
 * @since 16NOV2023
 * Description: This class helps to log any exceptions within our program and write them to a file
 */
public class ExceptionLogger {
    
    //! Name the instance of the logger to the class name.
    private static Logger logger = Logger.getLogger(ExceptionLogger.class.getName());
    private FileHandler fileHandler;
    

    /**
     * Description: Default, Constructor.
     */
    public ExceptionLogger(){}
    
    /**
     * Description: Get the logger to use.
     * @return The logger data.
     */
    public static Logger getLogger() {
        return logger;
    }


    /**
     * Description: Sets the logger to use.
     * @param logger HOlds logger data.
     */
    public static void setLogger(Logger logger) {
        ExceptionLogger.logger = logger;
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
    /**
     * Description: This method sets up the directory to log the exceptions thrown during the program.
     */
    public synchronized void configureExceptionDirectory(){
        try {
            //! Get the path and make or open directory.
            File exceptionLogger = new File("ExceptionLogger");
            exceptionLogger.mkdir();

        } catch (Exception e) {
            //! Log exception thrown.
            logExceptionsThrown(e);
        }
    }
    
    /**
     * Description: This method sets up the logger to use.
     */
    public synchronized void configureLogger(){
        try {
            //! Do not write to terminal.
            getLogger().setUseParentHandlers(false);

            //! Get the file specified.
            setFileHandler(new FileHandler("ExceptionLogger/Exception_log.txt", true));
            //! For readability in .txt file.
            getFileHandler().setFormatter(new SimpleFormatter());
            //! Allows us to use config, finer etc.
            getLogger().setLevel(Level.ALL);
            //! Store teh fileHandler to write to file.
            getLogger().addHandler(getFileHandler());
        } catch (Exception e) {
            //! Log exception thrown.
            logExceptionsThrown(e);
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
     * Description: This method logs exceptions that are thrown during program execution.
     * @param throwable Holds the throwable exception made
     */
    public static synchronized void logExceptionsThrown(Throwable throwable){
        //! Logs with highest warming.
        getLogger().log(Level.SEVERE, "Exception happened during program", throwable);
    }

    /**
     * Description: This method flushed the .txt file of exception logger.
     */
    public void flushExceptionFile(){
        try {

            //!Get customer file to write to.
            FileOutputStream fileOut = new FileOutputStream("ExceptionLogger/Exception_log.txt");
            
            //! Used to write to the customer file we passed in constructor.
            PrintWriter printWriter = new PrintWriter(fileOut);
            
            //! Clear the contents in the customer file.
            printWriter.println("");
            
            //! Writes data quickly to the customer file.
            printWriter.flush();
            
            //! When done writing to customer file, close fileOutputStream.
            fileOut.close();
            
        } catch (FileNotFoundException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        catch(IOException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }
}



