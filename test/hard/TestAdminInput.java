package hard;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import main.AdminEventModifier;
import main.ConfigureEventDetails;
import main.EventFactory;
import main.VenueFactory;

public class TestAdminInput{
    private AdminEventModifier adminEventModifier;
    private ConfigureEventDetails configureEventDetails;

    @Before
    public void setUp() throws Exception{
        configureEventDetails = new ConfigureEventDetails("EventListPA5.csv", new EventFactory(), new VenueFactory());
        configureEventDetails.setFileDataToAttributes();
        adminEventModifier = new AdminEventModifier();
    }

    @Test
    public void testEventNameInput(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String simulatedInput = "UTEP Basketball 9\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(output));
        try{
            String eventName = adminEventModifier.changeEventName("name");
        }
        catch(NoSuchElementException e){
            String expectedResult = "Input new event name"+ System.lineSeparator() +">> Event name already exist."+ System.lineSeparator() +"Input new event name"+ System.lineSeparator() +">> ";
            assertEquals(expectedResult, output.toString());
        }
    }
    @Test
    public void testEventDateInput(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String simulatedInput = "2/29/2023\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(output));
        try{
            String eventDate = adminEventModifier.changeDate();
        }
        catch(NoSuchElementException e){
            String expectedResult = "\033[H\033[2JPlease enter time in this formate (MM/DD/YY). Ex: 12/20/2001"+ System.lineSeparator() +
                                    ">> Invalid date"+ System.lineSeparator() +"\033[H\033[2JPlease enter time in this formate (MM/DD/YY). Ex: 12/20/2001"+ System.lineSeparator() +">> ";
            assertEquals(expectedResult, output.toString());
        }
    }
    @Test
    public void testEventTimeInput(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String simulatedInput = "25:00\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(output));
        try{
            String eventTime = adminEventModifier.changeTime();
        }
        catch(NoSuchElementException e){
            String expectedResult = "\033[H\033[2JPlease enter time in this 12 hour formate (HH:MM). Ex: 11:03"+ System.lineSeparator() + 
                                    ">> \033[H\033[2JPlease enter time in this 12 hour formate (HH:MM). Ex: 11:03"+ System.lineSeparator() +">> ";
            assertEquals(expectedResult, output.toString());
        }
    }

}