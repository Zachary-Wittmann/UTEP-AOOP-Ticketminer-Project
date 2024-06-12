package medium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import main.MenuHandler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestMenuHandler {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private MenuHandler menuHandler;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        menuHandler = new MenuHandler();
    }

    @Test
    public void testTypeOfUserMenu() {
        menuHandler.typeOfUserMenu();

        String expectedOutput = "Are you an admin or a customer?" + System.lineSeparator()
                                + "1. Admin" + System.lineSeparator()
                                + "2. Customer" + System.lineSeparator()
                                + "3. Exit" + System.lineSeparator()
                                + ">> ";

        assertEquals(expectedOutput, outContent.toString());

    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}