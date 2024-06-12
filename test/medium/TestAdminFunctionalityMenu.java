package medium;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.MenuHandler;

public class TestAdminFunctionalityMenu {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;
    private MenuHandler menuHandler;
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
        menuHandler = new MenuHandler();
    }

    @Test
    public void testPrintAdminFunctionalityMenu() {
        menuHandler.printAdminFunctionalityMenu();

        String expectedOutput = "\n1: View event analytics" + System.lineSeparator() +
                                "2: Do auto shopping" + System.lineSeparator() +
                                "3: Do team auto shopping" + System.lineSeparator() +
                                "4: Add new event" + System.lineSeparator() +
                                "5: Cancel an event" + System.lineSeparator() +
                                "6: Modify an event" + System.lineSeparator() +
                                "7: Obtain Electronic Invoice Summary of specific customer" + System.lineSeparator() +
                                "8: Log out of account" + System.lineSeparator() +
                                ">> ";
                                
        assertEquals(expectedOutput, output.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}

