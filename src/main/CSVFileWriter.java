package main;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * Description: This class implements a singleton design pattern. IT is meant to only write to am excel file. Class and method came from Raul.
 * @author Raul Pallares
 * @since 9/30/2023
 */
public class CSVFileWriter {
    
    //! Static is Global -> Can be accessed from outside the class.
    private static CSVFileWriter csvFileWriter;


    /**
     * Description: Default Constructor, Creating singleTon design pattern in a special way.
     */
    private CSVFileWriter(){}


    /* Description: This method gets the instance of csvFileWriter (singleton design pattern).
    * synchronized is so we do not access the same object at the same time.
    * @return The csvFileWriter object.
    */
    public static synchronized CSVFileWriter getInstance(){
        //! If object not already created, then create it.
        if(csvFileWriter == null)
            csvFileWriter = new CSVFileWriter();
        //! Return the object.
        return csvFileWriter;
    }

    /**
     * Description: This method writes to any excel file.
     * @param fileData Holds data to write to.
     * @param filename  Holds the file to write to.
     */
    public void writeFile(ArrayList<String[]> fileData, String filename){

        try{

            //! Get file to write to.
            FileOutputStream fileOut = new FileOutputStream(filename);
            //! Used to write to file.
            PrintWriter printWriter = new PrintWriter(fileOut);

            //! Run through the data.
            for (int i = 0; i < fileData.size(); i++) {
                //! Get data line by line.
                String[] rowData = fileData.get(i);
                //! Do reverse of when reading in data to write data to a file.
                String rowText = String.join(",", rowData);
                //! Write to the file.
                printWriter.println(rowText); 
            }

            //! Write quickly to file.
            printWriter.flush();
            //! CLose print writer and fileOut when done with file.
            printWriter.close();
            fileOut.close();

        } catch (IOException e) {
            //! Log the exception that happened.
            ExceptionLogger.logExceptionsThrown(e);
        }
    }   

}