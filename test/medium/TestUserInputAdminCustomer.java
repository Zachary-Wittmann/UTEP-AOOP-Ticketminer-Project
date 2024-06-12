package medium;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.AdminOrCustomer;

public class TestUserInputAdminCustomer {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream originalOut = System.out;
    private AdminOrCustomer adminOrCustomer;
    
    @Before
    public void setUp() {
        adminOrCustomer = new AdminOrCustomer();
    }

    @Test
    public void testChooseAdminOrCustomer() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        System.setOut(new PrintStream(outputStream));
        int result = adminOrCustomer.chooseAdminOrCustomer();
        assertEquals(1, result);
    }

    @After
    public void restoreStreams() {
        System.setIn(System.in);
        System.setOut(originalOut);
    }
    
}
