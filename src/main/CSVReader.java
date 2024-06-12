package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The CSVReader.java file is used to read a csv file that will be provided.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */
public class CSVReader {

    //! Static is Global -> Can be accessed from outside the class.
    private static CSVReader csvReader; 

    /**
     * Description: Creates an instance of the CSVReader
     */
    private CSVReader() {
    }

    /**
     * Description: This method gets the instance of csvReader (singleton design pattern).
     * synchronized is so we do not access the same object at the same time.
     * @return The csvReader object.
     */
    public static synchronized CSVReader getInstance(){
        //! If object not create, then create it.
        if(csvReader == null)
            csvReader = new CSVReader();
        //! Return the object.
        return csvReader;
    }

    /**
     * Description: This method stores the header of an excel file.
     * @param fileData Holds the reference to the array list that holds the file data.
     * @param filename Holds the file name to be read in.
     */
    public void storeHeader(ArrayList<String[]> fileData, String filename) {

        try {
            //! Open the file to read.
            File file = new File(filename);
            //! Allows for reading in the file. 
            Scanner textReader = new Scanner(file);
            //! Store the header line from the excel file.
            fileData.add(textReader.nextLine().split(","));
            //! Close when done reading from file.
            textReader.close();
        } catch (FileNotFoundException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }

    }

    /**
     * Description: This method Reads in and stores the data from an excel file in an array list.
     * @param filename Holds the name of the excel file to be read in.
     * @return The array list of file data on read.
     */
    public ArrayList<String[]> readCSV(String fileName) {

        //! Create new array list of String 1D arrays.
        ArrayList<String[]> data = new ArrayList<>();

        try {
            //! Open file to read.
            File file = new File(fileName);
            //! Allows for reading in the data from file.
            Scanner reader = new Scanner(file);
            
            //! Store the header of the excel file.
            storeHeader(data, fileName);

            //! Get cell length.
            int size = reader.nextLine().split(",").length;

            //! Run through excel data.
            while (reader.hasNext()) {
                //! Store the data read in lin by line in a string 1D array.
                String[] temp = reader.nextLine().split(",", size);
                //! Add the line data to the array to store it.
                data.add(temp);
            }
            //! Close when done with excel file.
            reader.close();

        } catch (FileNotFoundException e) {
            //! LOg the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
        //! Return the array that holds excel data.
        return data;
    }
}