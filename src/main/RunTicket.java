package main;

/**
 * Lab Description: This is the main class that will run the Run ticket miner system. This program has existing functionality from previous lab. Has merged code. New functionality is
 * adding new events, printing ticket bought for event, storing customer invoices. 
 * @author Extreme Software Development Team LLC
 * @since 11/2/2023
 * Course: CS 3331 – Advanced Object-Oriented Programming – Spring 2023
 * Instructor: Daniel Mejia
 * Programming assignment 4
 * HONESTY STATEMENT: This work has been completed only using assistance from
 *                    the instructor, TA, and/or IA
 */
public class RunTicket{


  public static void main(String[] args){

    ExceptionLogger exceptionLogger = new ExceptionLogger();

    try {

      //! Configure exception logger.
      exceptionLogger.configureExceptionDirectory();
      exceptionLogger.configureLogger();
      exceptionLogger.flushExceptionFile();


      //! creates events data's
      ConfigureEventDetails configureEventDetails = new ConfigureEventDetails("EventListPA5.csv", new EventFactory(), new VenueFactory());
      configureEventDetails.setFileDataToAttributes();
    
      //! Create customer data
      CustomerCreator customerCreator = new CustomerCreator("CustomerListPA5.csv");
      customerCreator.createCustomers();
  
  
  
      //! Create object to run program.
      DoMainProgram doMainProgram = new DoMainProgram();
  
      //! Run the program.
      doMainProgram.runProgramLogic();
      
    } catch (NullPointerException e) {
        //! Log exception that happened.
        ExceptionLogger.logExceptionsThrown(e);
    }finally{
        exceptionLogger.closeLogger();
    }
  }

}
