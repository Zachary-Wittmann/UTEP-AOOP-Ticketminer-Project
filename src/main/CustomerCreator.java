package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.HashMap;

/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The CustomerCreator.java file is used to create Customers for the customer hashmap from the arrayList made by the CSVReader.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */
public class CustomerCreator {

    //! Store the file name of the  customer excel.
    private String filename;


    /**
     * Creates an instance of the CustomerCreator
     */
    public CustomerCreator() {

    }

    /**
     * Description: Constructor, store file name.
     * @param filename Holds file name.
     */
    public CustomerCreator(String filename){
        setFilename(filename);
    }



    /**
     * Description: Set the file name for customer excel file.
     * @param filename Holds file name.
     */
    public void setFilename(String filename){
        this.filename = filename;
    }
    /**
     * Description: Gets the file name of the customer excel.
     */
    public String getFilename(){
        return this.filename;
    }

    /**
     * Description: Create the customers from excel data. We will store the data, store the indexes and store the customer in the haspmap.
     */
    public void createCustomers(){

        try {
            //! Create a hashmap of key-> string, value -> string
            HashMap<String, String> hashMapFileData = new HashMap<>();

            //! Create reference.
            CSVReader csvFileReader = CSVReader.getInstance();
            //!Create reference.
            FileDataStorage fileDataStorage = FileDataStorage.getInstance();

            ArrayList<String[]> fileData = fileDataStorage.getCustomerFileData();

            //! Store the read in file data into and arraylist of 1D array of stings.
            fileData = csvFileReader.readCSV(getFilename());

            //! Store the data for customer list.
            fileDataStorage.setCustomerFileData(fileData);


            //! This is where the header line from the file read is located at.
            String [] headerLine = fileData.get(0);

            //! Create reference.
            HeadersLocations customerHeaderReference = HeadersLocations.getInstance();

            //! Get the location of the header cells
            HashMap<String, Integer> customerCelLocations = customerHeaderReference.getHeaderLocationCustomer();

            //! Store the header with the associated column number of its position in the excel file.
            for (int i = 0; i < headerLine.length; i++) {
                customerCelLocations.put(headerLine[i].toLowerCase(), i);
            }
            //! Store the line data line by line.
            for (int index = 1; index < fileData.size(); index++) {
                String []rowText = fileData.get(index);

                //! Store the header name-> key and value -> data.
                for (int rtIndex = 0; rtIndex < rowText.length; rtIndex++) {
                    hashMapFileData.put(headerLine[rtIndex].toLowerCase(), rowText[rtIndex]);
                }
                //! Store the  individual customer.
                createTheCustomer(hashMapFileData);
            }  
        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch(ArrayIndexOutOfBoundsException e){
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }


    }

    /**
     * Description: Set and store the customer data in the hasmap.
     * @param fileData Holds the customer data.
     */
    public void createTheCustomer(HashMap<String,String> fileData){
        try {
            //! Create new customer object.
            Customer customer = new Customer(new CustomerLogger());

            //! TO help convert the string data from excel file to correct data type for hte attributes.
            ConversionOfDataTypes conversion = ConversionOfDataTypes.getInstance(); 

            //! Run though the hashMap data. key-> header names, value -> cell associated with the header.
            for (String key : fileData.keySet()) {

                switch(key){

                    case "id":
                        customer.setCustomerID(conversion.convertToInteger(fileData.get(key)));
                        break;
                    case "first name":
                        customer.setFirstName(conversion.convertToString(fileData.get(key)));
                        break;
                    case "last name":
                        customer.setLastName(conversion.convertToString(fileData.get(key)));
                        break;
                    case "money available":
                        customer.setCustomerMoneyAvailable(conversion.convertToDouble(fileData.get(key)));
                        break;
                    case "tickets purchased":
                        customer.setCustomerTicketsPurchased(conversion.convertToInteger(fileData.get(key)));
                        break;
                    case "ticketminer membership":
                        customer.setCustomerMembership(conversion.convertStringToBoolean(fileData.get(key)));
                        break;
                    case "username":
                        customer.setCustomerUsername(conversion.convertToString(fileData.get(key)));
                        break;
                    case "password":
                        customer.setCustomerPassword(conversion.convertToString(fileData.get(key)));
                        break;
                    default:
                        break;
                }
            }     
            //! Set logger name and configure logger for customer.
            customer.getCustomerLogger().setFileName(customer.getLastName() + "_" + customer.getFirstName());
            customer.getCustomerLogger().setLogger();

            //! Store teh customer full name as key and the ID as the pair value.
            Customer.getCustomerName().put(customer.getFirstName().toLowerCase() + " "+ customer.getLastName().toLowerCase(), customer.getCustomerID());
            //! Store the username and passwords as key and the ID as value pair.
            Customer.getCustomerUsernameAndPassword().put(customer.getCustomerUsername() + " " + customer.getCustomerPassword(), customer.getCustomerID());

            //! Store in the hashmap, key-> customer id, value-> the customer object.
            Customer.getCustomerMap().put(customer.getCustomerID(), customer);


        } catch (NullPointerException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        } catch (InputMismatchException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }


}
