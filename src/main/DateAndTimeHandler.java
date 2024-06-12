package main;

/**
 * Description: This class is a singleton for handling the date and time.
 * @author Extreme Software Development Team LLC
 */
public class DateAndTimeHandler {

    
    //! Static is Global -> Can be accessed from outside the class. 
    private static DateAndTimeHandler dateAndTimeHandler;

    /**
     * Description: Default Constructor, Creating singleTon design pattern in a special way.
     */
    private DateAndTimeHandler(){}


    /**
     * Description: This method gets the instance of DateAndTimeHandler (singleton design pattern).
     * synchronized is so we do not access the same object at the same time.
     * @return The DateAndTimeHandler object.
     */
    public static synchronized  DateAndTimeHandler getInstance(){
        if(dateAndTimeHandler == null)
            dateAndTimeHandler = new DateAndTimeHandler();
        return dateAndTimeHandler;
    }

    /**
     * Description: This methods will prompt the user to set the time and check if its valid.
     * @param time Holds the time the user inputed.
     * @return true for valid or false for not valid.
     */
    public boolean checkTime(String time){
        //! Get reference.
        ConversionOfDataTypes conversion = ConversionOfDataTypes.getInstance();

        try {
            //! Split time.
            String[] timeFormate = time.trim().split(":");

            //! Check if it is of length two else return false.
            if(timeFormate.length != 2)
                return false;
            
            //! Store the hour and the minutes.    
            int hour = conversion.convertToInteger(timeFormate[0].trim());
            int minutes = conversion.convertToInteger(timeFormate[1].trim());

            //! Check if time is correct in range, if so return true else return false.
            if((hour > 0 && hour < 13) && (minutes >= 0 && minutes < 60))
                return true;
            else
                return false;
        } catch (NumberFormatException  e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        //! Return false. Time wrong.
        return false;
    } 

    /**
     * Description: This methods prompts user to set Date and checks if valid.
     * @param date Holds the date user inputed.
     * @return true for valid.
     */
    public boolean checkDate(String date){

        //! Create reference.
        ConversionOfDataTypes conversion = ConversionOfDataTypes.getInstance();
        try {
            //! Split Date.
            String[] dateFormate = date.trim().split("/");


            //! Not correct date formate.
            if(dateFormate.length != 3)
                return false;

            //! Store the month, day and year.   
            int month = conversion.convertToInteger(dateFormate[0].trim());
            int day = conversion.convertToInteger(dateFormate[1].trim());
            int year = conversion.convertToInteger(dateFormate[2].trim());

            //! Check if month, dya and year are correct, in range if not return false if so return true at the end.
            if(month <= 0 || month > 12){
                System.out.println("Invalid month");
                return false;
            }
            if((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)){
                if(day <= 0 || day > 31){
                    System.out.println("Invalid date");
                    return false;
                }
            }
            if((month == 4) || (month == 6) ||(month == 9) || (month == 11) ){
                if(day <= 0 || day > 30){
                    System.out.println("Invalid date");
                    return false;
                }
            }
            if(month == 2){
                if(year % 4 == 0){
                    if(day <= 0 || day > 29){
                        System.out.println("Invalid date");
                        return false;
                    }
                }
                else if(day <= 0 || day > 28){
                        System.out.println("Invalid date");
                        return false;
                }
            }
            if(year < 2022){
                System.out.println("year has passed");
                return false;
            }
            return true;
        
        } catch (NumberFormatException  e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        //! Return false. Data wrong.
        return false;
    }


}