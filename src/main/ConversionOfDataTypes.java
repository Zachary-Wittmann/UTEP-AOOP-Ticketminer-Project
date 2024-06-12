package main;
/**
 * Description: This class implements a singleton design pattern. It is meant to help convert the string data read in from an excel file to the equivalent data type. 
 * I do not need to create multiple objects of this class, I only need one that can help with conversions and that it. Class and method came from Raul.
 * @author Raul Pallares
 * @since 9/29/2023
 */
public class ConversionOfDataTypes {
    

    //! Static is Global -> Can be accessed from outside the class.
    private static ConversionOfDataTypes conversion;


    /**
     * Description: Default Constructor, Creating singleTon design pattern in a special way.
     */
    private ConversionOfDataTypes(){}


    /**
     * Description: This method gets the instance of ConversionOfDataTypes (singleton design pattern).
     * synchronized is so we do not access the same object at the same time.
     * @return The conversion object.
     */
    public static synchronized ConversionOfDataTypes getInstance(){
        //! If object not created, create it.
        if(conversion == null)
            conversion = new ConversionOfDataTypes();
        //! Return the object
        return conversion;
    }

    /**
     * Description: This method converts a string into a boolean.
     * @param isBoolean Holds the string to be converted.
     * @return The boolean equivalent of the string.
     */
    public boolean convertStringToBoolean(String isBoolean ){
        //! If string is empty, if so return false.
        if(isBoolean.isEmpty())
            return false;
        //! If String is "yes", return true.
        else if((isBoolean.equalsIgnoreCase("yes") ) ||  (isBoolean.equalsIgnoreCase("true")))
            return true;
        //! Return false for anything else.
        return false;
    }

    /**
     * Description: This method converts the string to a double.
     * @param doubleNumber Holds the string to be converted.
     * @return The double equivalent of the string. 
     */
    public double convertToDouble(String doubleNumber){
        //! If string is empty, if so return default double.
        if(doubleNumber.isEmpty())
            return 0.0;
        //! return converted double value.
        return Double.valueOf(doubleNumber);
    }

    /**
     * Description: This method converts a string to an integer.
     * @param integerNumber Holds the string to be converted.
     * @return The Integer equivalent of the string.
     */
    public int convertToInteger(String integerNumber){
        //! If string empty, return default integer.
        if(integerNumber.isEmpty())
            return 0;
        //! Return converted integer value.
        return Integer.valueOf(integerNumber);
    }

    /**
     * Description: This method converts string to string.
     * @param stringName Holds the string to be converted.
     * @return The String
     */
    public String convertToString(String stringName){
        //! If string empty, return empty string.
        if(stringName.isEmpty())
            return "";
        //! Return the string itself.
        return stringName; 
    }

    /**
     * Description: This method converts boolean to string.
     * @param booleanName Holds the boolean to be converted.
     * @return The string equivalent of the boolean.
     */
    public String convertBooleanToString(boolean booleanName){
        //! If boolean is true return string "yes", else return string "no".
        if(booleanName)
            return "yes";
        else    
            return "no";
    }


    /**
     * Description: THis method converts double to string.
     * @param doubleValue Holds double to be converted.
     * @return The string equivalent of the double.
     */
    public String convertDoubleToString(double doubleValue){
        return String.valueOf(doubleValue);
    }

    /**
     * Description: THis method converts integer to string.
     * @param intValue Holds integer to be converted.
     * @return The string equivalent of the integer.
     */
    public String convertIntegerToString(int intValue){
        return String.valueOf(intValue);
    }



}
