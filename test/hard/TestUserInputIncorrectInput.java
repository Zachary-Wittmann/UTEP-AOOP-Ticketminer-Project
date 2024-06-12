package hard;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import main.UserInputHandler;

public class TestUserInputIncorrectInput {
    private UserInputHandler userInputHandler;

    @Before
    public void setUp() {
        userInputHandler = new UserInputHandler();
    }

    @Test(expected = NoSuchElementException.class)
    public void testIsUnexpectedInputABC() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream("abc\n".getBytes()));
        System.setOut(new PrintStream(output));
        Scanner scanner = new Scanner(System.in);
        int result = userInputHandler.isInRange(scanner, 1, 10);
        String expectedResult = "Please enter valid in range integer option\n>> ";
        assertEquals(expectedResult, output.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIsUnexpectedInputChar() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream("#\n".getBytes()));
        System.setOut(new PrintStream(output));
        Scanner scanner = new Scanner(System.in);
        int result = userInputHandler.isInRange(scanner, 1, 10);
        String expectedResult = "Please enter valid in range integer option\n>> ";
        assertEquals(expectedResult, output.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIsUnexpectedInputNeg() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream("-1\n".getBytes()));
        System.setOut(new PrintStream(output));
        Scanner scanner = new Scanner(System.in);
        int result = userInputHandler.isInRange(scanner, 1, 10);
        String expectedResult = "Please enter valid in range integer option\n>> ";
        assertEquals(expectedResult, output.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIsUnexpectedInputNonNeg() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream("77\n".getBytes()));
        System.setOut(new PrintStream(output));
        Scanner scanner = new Scanner(System.in);
        int result = userInputHandler.isInRange(scanner, 1, 10);
        String expectedResult = "Please enter valid in range integer option\n>> ";
        assertEquals(expectedResult, output.toString());
    }
}
