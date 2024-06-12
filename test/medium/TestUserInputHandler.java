package medium;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.UserInputHandler;

public class TestUserInputHandler {
    private UserInputHandler userInputHandler;

    @Before
    public void setUp() {
        userInputHandler = new UserInputHandler();
    }

    @Test
    public void testIsInRange() {
        System.setIn(new ByteArrayInputStream("5\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        int result = userInputHandler.isInRange(scanner, 1, 10);
        assertEquals(5, result);
    }

    @After
    public void restoreStreams() {
        System.setIn(System.in);
    }
}
