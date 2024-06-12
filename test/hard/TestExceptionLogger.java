package hard;

import org.junit.Before;
import org.junit.Test;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import main.ExceptionLogger;

public class TestExceptionLogger {
    private ExceptionLogger exceptionLogger;

    @Before
    public void setUp() {
        exceptionLogger = new ExceptionLogger();
    }

    @Test
    public void testConfigureLogger() {
        exceptionLogger.configureLogger();

        assertEquals(Level.ALL, exceptionLogger.getLogger().getLevel());
        assertFalse(exceptionLogger.getLogger().getUseParentHandlers());

        boolean hasFileHandler = false;
        for (Handler handler : exceptionLogger.getLogger().getHandlers()) {
            if (handler instanceof FileHandler) {
                hasFileHandler = true;
                break;
            }
        }
        assertTrue(hasFileHandler);
    }

    @Test
    public void testConfigureLoggerNoFileHandler() {
        // Configure the logger without adding a FileHandler
        exceptionLogger.getLogger().setUseParentHandlers(false);
        exceptionLogger.getLogger().setLevel(Level.ALL);

        assertEquals(Level.ALL, exceptionLogger.getLogger().getLevel());
        assertFalse(exceptionLogger.getLogger().getUseParentHandlers());

        boolean hasFileHandler = false;
        for (Handler handler : exceptionLogger.getLogger().getHandlers()) {
            if (handler instanceof FileHandler) {
                hasFileHandler = true;
                break;
            }
        }
        assertFalse(hasFileHandler);
}
}